package io.h3llo.ecoeats.presentation.recipes

import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.FileUpload
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import io.h3llo.ecoeats.presentation.common.ButtonBasic
import io.h3llo.ecoeats.presentation.common.SpacerComponent
import io.h3llo.ecoeats.presentation.common.TextBasic
import io.h3llo.ecoeats.presentation.preview.PreviewDefault
import io.h3llo.ecoeats.presentation.util.Util


@Composable
fun RecipeRegistrationScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    viewModel: RecipeRegistrationViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val formState by viewModel.formState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    if (state.error != null) {
        Toast.makeText(context, state.error, Toast.LENGTH_SHORT).show()
    }
    if (state.success != null) {
        Toast.makeText(context, state.success, Toast.LENGTH_SHORT).show()
    }

    // TODO implement the CustomDialog for all Screens

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }


    val singlePhotoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        viewModel.onEvent(event = RecipeRegistrationFormEvent.ImageChange(uri))
    }

    val cameraPhotoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val data = result.data?.extras?.get("data") as Bitmap
        viewModel.onEvent(RecipeRegistrationFormEvent.ImageChange(Util.getImageUri(data, context)))
    }

    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { permission ->
        when {
            permission -> {
                // PERMISSION GRANTED
                cameraPhotoLauncher.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
            }

            else -> {
                // PERMISSION DENIED
            }
        }
    }



    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextBasic(
            text = "REGISTRO DE RECETAS", style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
        SpacerComponent(modifier = Modifier.height(64.dp))
        OutlinedTextField(
            value = formState.title,
            onValueChange = { title ->
                viewModel.onEvent(RecipeRegistrationFormEvent.TitleChange(title))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        )
        SpacerComponent(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = formState.description,
            onValueChange = { description ->
                viewModel.onEvent(RecipeRegistrationFormEvent.DescriptionChange(description))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        )
        SpacerComponent(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                cameraPermissionLauncher.launch(
                    android.Manifest.permission.CAMERA
                )
            }) {
                Icon(
                    imageVector = Icons.Filled.CameraAlt,
                    contentDescription = "Camera",
                    modifier = Modifier
                        .width(300.dp)
                        .height(300.dp)
                )
            }
            SpacerComponent(modifier = Modifier.width(32.dp))
            IconButton(onClick = {
                singlePhotoLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }) {
                Icon(
                    imageVector = Icons.Filled.FileUpload,
                    contentDescription = "Camera",
                    modifier = Modifier
                        .width(300.dp)
                        .height(300.dp)
                )
            }

        }
        SpacerComponent(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(width = 1.dp, color = Color.Gray, CircleShape)
                .background(Color.LightGray),
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(formState.uri)
                    .crossfade(500)
                    .build(),
                contentDescription = "Preview",
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        SpacerComponent(modifier = Modifier.height(64.dp))
        ButtonBasic(
            text = "Registrar",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            viewModel.onEvent(RecipeRegistrationFormEvent.Submit)
        }

    }

}

@PreviewDefault
@Composable
fun RecipeRegistrationScreenPreview() {
    RecipeRegistrationScreen(paddingValues = PaddingValues())
}
