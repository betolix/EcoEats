package io.h3llo.ecoeats.presentation.sign_in

import android.widget.Toast
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import io.h3llo.ecoeats.R
import io.h3llo.ecoeats.presentation.common.AlertCustom
import io.h3llo.ecoeats.presentation.common.ButtonBasic
import io.h3llo.ecoeats.presentation.common.ImageBasic
import io.h3llo.ecoeats.presentation.common.LoadingScreen
import io.h3llo.ecoeats.presentation.common.OutlinedTextFieldBasic
import io.h3llo.ecoeats.presentation.common.SpacerComponent
import io.h3llo.ecoeats.presentation.common.TextBasic
import io.h3llo.ecoeats.presentation.util.Util.scheduleWork
import io.h3llo.ecoeats.ui.theme.Primary
import io.h3llo.ecoeats.workers.SyncWorkManager
import java.util.concurrent.TimeUnit

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    //viewModel: SignInViewModel = viewModel()
    viewModel: SignInViewModel = hiltViewModel(),
    onNavigationHome: () -> Unit
) {


    Column(
        modifier = modifier.fillMaxSize()
    ) {

        val state = viewModel.state
        val context = LocalContext.current


//        if (viewModel.state.isLoading) {
//            // CircularProgressIndicator()
//            LoadingScreen(showLoading = true)
//        }


        LoadingScreen (showLoading = viewModel.state.isLoading)

        LaunchedEffect(key1 = Unit) {
            /*val worker = OneTimeWorkRequest.Builder(
                SyncWorkManager::class.java
            ).build()*/


            /*
            val worker = PeriodicWorkRequestBuilder<SyncWorkManager>(
                15, TimeUnit.MINUTES
            ).build()

            // WorkManager.getInstance(context).enqueue(worker)

            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                "SyncData",
                ExistingPeriodicWorkPolicy.REPLACE,
                worker

            ) */

            context.scheduleWork()
        }


        LaunchedEffect(key1 = state.success, key2 = state.error) {
            if (state.success != null) {
                // println(state.success?.email)
                Toast.makeText(context, state.success?.email, Toast.LENGTH_SHORT).show()
                onNavigationHome()
            }
            if (state.error != null) {
                println(state.error)
                // Toast.makeText(context, state.error, Toast.LENGTH_LONG).show()
                viewModel.onEvent(LoginFormEvent.showDialog(isVisible = true))
            }
        }

        if (viewModel.formState.showDialog) {
            AlertCustom(
                // title = state.error ?: "",
                title = buildAnnotatedString {
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Mensaie de error: ")
                    }
                    append(state.error ?: "")
                },
                dismiss = {
                    viewModel.onEvent(LoginFormEvent.showDialog(isVisible = false))
                }
            )
        }


        /*
        if (state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        */

        if (state.success != null) {
            println(state.success?.email)
        }

        Column(
            modifier = modifier
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

            SignInContent(viewModel = viewModel)

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                // .background(Color.Red)
                .padding(start = 24.dp, end = 24.dp, top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,


            ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
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
            HorizontalDivider(modifier = Modifier.width(300.dp))
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
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                content = {
                    TextBasic(
                        text = "Regístrate",
                        style = TextStyle(
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
fun SignInContent(
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel
) {

    /*
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var visualTransformation by remember {
        mutableStateOf(false)
    }
    */

    val focusManager = LocalFocusManager.current

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
        text = viewModel.formState.email,
        onValueChange = {
            // email = it
            viewModel.onEvent(LoginFormEvent.EmailChange(it))
        },
        textLabel = "Email",
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
                viewModel.onEvent(LoginFormEvent.onFocusChange)
            }
        ),
        trailingIcon = {
            IconButton(onClick = {
                // email = ""
                viewModel.onEvent(LoginFormEvent.EmailChange(""))
            }) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "Clear"
                )
            }
        },
        isError = viewModel.formState.emailError != null,
    )
    if (viewModel.formState.emailError != null) {
        TextBasic(
            text = viewModel.formState.emailError ?: "",
            style = TextStyle(fontSize = 15.sp),
            color = Color.Red
        )
    }

    OutlinedTextFieldBasic(
        text = viewModel.formState.password,
        onValueChange = {
            // password = it
            viewModel.onEvent(LoginFormEvent.PasswordChange(it))
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
            IconButton(onClick = {
                //visualTransformation = !visualTransformation
                viewModel.onEvent(LoginFormEvent.VisualTransformationChange(!viewModel.formState.visualTransformation))
            }) {
                Icon(
                    imageVector = if (viewModel.formState.visualTransformation) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = "Visible"
                )
            }
        },
        visualTransformation = if (viewModel.formState.visualTransformation) PasswordVisualTransformation() else VisualTransformation.None,
        isError = false,
    )
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        ButtonBasic(modifier = Modifier.fillMaxWidth(),
            text = "Ingresar",
            onClick = {
                // viewModel.signIn(email, password)
                viewModel.onEvent(LoginFormEvent.Submit)
            }
        )
    }
    /*
    if (viewModel.state.isLoading) {
        CircularProgressIndicator()
    }
    */

}

@Composable
fun SignInHeader(modifier: Modifier = Modifier) {

    ImageBasic(
        image = R.drawable.ecoeats_logo,
        description = "Ecoeats logo",
        modifier = Modifier.size(150.dp)
    )
}

//@PreviewDefault
//@Composable
//private fun SignInScreenPreview() {
//    SignInScreen()
//}