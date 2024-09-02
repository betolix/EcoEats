package io.h3llo.ecoeats.presentation.sign_in

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.h3llo.ecoeats.R
import io.h3llo.ecoeats.presentation.common.ButtonBasic
import io.h3llo.ecoeats.presentation.common.ImageBasic
import io.h3llo.ecoeats.presentation.common.OutlinedTextFieldBasic
import io.h3llo.ecoeats.presentation.common.SpacerComponent
import io.h3llo.ecoeats.presentation.common.TextBasic
import io.h3llo.ecoeats.presentation.preview.PreviewDefault
import io.h3llo.ecoeats.ui.theme.Primary
import io.h3llo.ecoeats.ui.theme.Secondary
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun SignInScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f),
            // .background(Color.Blue),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SignInHeader()
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .padding(start = 24.dp, end = 24.dp, top = 24.dp),
            //.background(Color.Green),

        ) {

            SignInContent()

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                // .background(Color.Red)
                .padding(start = 24.dp, end = 24.dp, top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,





            ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
            ){
                TextBasic(
                    text = "¿Olvidaste tu constraseña?  ", style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    modifier = modifier
                )
                TextBasic(
                    text = "Ingresa aquí", style = TextStyle(
                        color = Primary,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = modifier
                )
            }
            SpacerComponent(modifier = Modifier.padding(top = 42.dp))
            HorizontalDivider(modifier = Modifier.width(300.dp) )
            TextBasic(
                text = "¿Aún no tienes cuenta?  ", style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier.padding(top = 42.dp)
            )
            SpacerComponent(modifier = Modifier.padding(top = 42.dp))
            OutlinedButton(
                onClick = {},
                content = {
                    TextBasic(
                        text = "Regístrate", style = TextStyle(
                            color = Primary,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal
                        ),

                    )
                }
            )


        }


    }

}

@Composable
fun SignInContent(modifier: Modifier = Modifier) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    TextBasic(
        text = "Login", style = TextStyle(
            color = Primary,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = modifier
    )
    SpacerComponent(modifier = Modifier.height(8.dp))
    OutlinedTextFieldBasic(
        text = email,
        onValueChange = {
            email = it
        },
        textLabel = "Email",
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ),
        keyboardActions = KeyboardActions(
            onNext = {

            }
        ),
        trailingIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "Clear"
                )
            }
        },
        isError = false,
    )

    OutlinedTextFieldBasic(
        text = password,
        onValueChange = {
            password = it
        },
        textLabel = "Password",
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ),
        keyboardActions = KeyboardActions(
            onNext = {

            }
        ),
        trailingIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.VisibilityOff,
                    contentDescription = "Clear"
                )
            }
        },
        isError = false,
    )
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        ButtonBasic(
            text = "Ingresar",
            onClick = {  }
        )
    }


}

@Composable
fun SignInHeader(modifier: Modifier = Modifier) {

    ImageBasic(
        image = R.drawable.ecoeats_logo,
        description = "Ecoeats logo",
        modifier = Modifier.size(150.dp)
    )
}

@PreviewDefault
@Composable
private fun SignInScreenPreview() {
    SignInScreen()
}