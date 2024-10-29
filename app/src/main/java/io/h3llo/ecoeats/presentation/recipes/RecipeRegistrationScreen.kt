package io.h3llo.ecoeats.presentation.recipes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.FileUpload
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.h3llo.ecoeats.presentation.common.ButtonBasic
import io.h3llo.ecoeats.presentation.common.SpacerComponent
import io.h3llo.ecoeats.presentation.common.TextBasic
import io.h3llo.ecoeats.presentation.preview.PreviewDefault

@Composable
fun RecipeRegistrationScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextBasic (text = "REGISTRO DE RECETAS", style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        ))
        SpacerComponent(modifier = Modifier.height(64.dp))
        OutlinedTextField(value = "", onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp))
        SpacerComponent(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
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
            IconButton(onClick = {/*TOD0*/ }) {
                Icon(
                    imageVector = Icons.Filled.CameraAlt,
                    contentDescription = "Camera",
                    modifier = Modifier
                        .width(300.dp)
                        .height(300.dp)
                )
            }
            SpacerComponent(modifier = Modifier.width(32.dp))
            IconButton(onClick = {/*TOD0*/ }) {
                Icon(
                    imageVector = Icons.Filled.FileUpload,
                    contentDescription = "Camera",
                    modifier = Modifier
                        .width(300.dp)
                        .height(300.dp)
                )
            }

        }
        SpacerComponent(modifier = Modifier.height(64.dp))
        ButtonBasic(text = "Registrar",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
            ){

        }

    }

}

@PreviewDefault
@Composable fun RecipeRegistrationScreenPreview(){
    RecipeRegistrationScreen(paddingValues = PaddingValues())
}
