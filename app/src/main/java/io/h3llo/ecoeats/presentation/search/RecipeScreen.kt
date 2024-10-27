package io.h3llo.ecoeats.presentation.search

//  POR QUE ESTA LIB NO SE IMPORTA AUTOMATICAMENTE ???
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import io.h3llo.ecoeats.domain.model.Recipe
import io.h3llo.ecoeats.presentation.common.OutlinedTextFieldBasic
import io.h3llo.ecoeats.presentation.common.TextBasic


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    viewModel: RecipeViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    val formState by viewModel.formState.collectAsStateWithLifecycle()


    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(RecipeFormEvent.GetRecipes)
    }

    //Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    //Text(text = "RecipeXXXS", modifier = Modifier.padding(paddingValues = paddingValues))
    //}

    if (viewModel.state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if (viewModel.state.error != null) {
        Toast.makeText(context, viewModel.state.error, Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        TextBasic(
            text = "Recetas",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 8.dp)
        )

        OutlinedTextFieldBasic(
            //text = viewModel.formState.searchValue,
            text = formState.searchValue,
            onValueChange = {
                if(it.all { it.isLetter() || it.isWhitespace() }){

                    viewModel.onEvent(RecipeFormEvent.TitleChange(it))
                    viewModel.onEvent(RecipeFormEvent.GetRecipesByTitle)
                }

            },
            textLabel = "Búsqueda",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {

                }
            ),
            isError = false,
            trailingIcon = {
                //if(viewModel.formState.searchValue.isEmpty()){
                if(formState.searchValue.isEmpty()){
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null
                    )
                }else{
                    IconButton(onClick = {
                        viewModel.onEvent(RecipeFormEvent.TitleChange(""))
                        viewModel.onEvent(RecipeFormEvent.GetRecipesByTitle)
                    }){
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = null
                        )
                    }

                }
            },
            modifier = Modifier.padding(horizontal = 8.dp).padding(bottom = 8.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            viewModel.state.success?.let {
                items(it) {
                    ItemRecipe(
                        recipe = it,
                        context = context
                    )
                }
            }

        }
    }
}

@Composable
fun ItemRecipe(
    modifier: Modifier = Modifier,
    recipe: Recipe,
    context: Context
) {
    //val context = LocalContext.current
    Card(
        border = BorderStroke(width = 1.dp, color = Color.Black),
        modifier = modifier.fillMaxWidth(),
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(recipe.url)
                    .build(),
                //modifier = Modifier.fillMaxWidth(),
                modifier = Modifier.height(200.dp),
                // WEEE
                contentScale = ContentScale.Crop,
                contentDescription = recipe.description,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                TextBasic(
                    text = recipe.title,
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                TextBasic(
                    text = recipe.description,
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Medium
                    )
                )

            }


        }

        // AsyncImage()

    }

}