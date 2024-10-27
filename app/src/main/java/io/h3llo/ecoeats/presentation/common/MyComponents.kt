package io.h3llo.ecoeats.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import io.h3llo.ecoeats.R
import io.h3llo.ecoeats.ui.theme.Primary
import io.h3llo.ecoeats.ui.theme.Secondary


@Composable
fun ImageBasic(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    description: String
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = description,
        modifier = modifier
    )
}

@Composable
fun SpacerComponent(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier)
}

@Composable
fun TextBasic(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    color: Color = Color.Unspecified
) {

    Text(
        modifier = modifier,
        text = text,
        style = style,
        color = color
    )

}

@Composable
fun ButtonBasic(
    modifier: Modifier = Modifier,
    text: String,
    containerColor: Color = Primary,
    contentColor: Color = Color.White,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick()
        },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Text(
            text = text
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldBasic(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    textLabel: String,
    roundedDp: Dp = 16.dp,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isError: Boolean
) {

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = {
            onValueChange(it)
        },
        label = {
            Text(
                text = textLabel,
            )
        },
        shape = RoundedCornerShape(roundedDp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Primary,
            focusedContainerColor = Secondary,
            focusedLabelColor = Primary,
            focusedIndicatorColor = Primary,
            focusedTrailingIconColor = Color.Red,
            focusedLeadingIconColor = Color.Red

        ),

        trailingIcon = trailingIcon,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        isError = isError
    )

}

@Composable
fun RatingBarcomponent(
    modifier: Modifier = Modifier,
    maxRating: Int = 5,
    currentRating: Int,
    starsColor: Color = Color.Yellow
) {
    Row {
        for (i in 1..maxRating) {
            Icon(
                imageVector = if (i <= currentRating) Icons.Filled.Star else Icons.Filled.StarOutline,
                contentDescription = "Stars",
                tint = if (i <= currentRating) starsColor else Color.Unspecified,
                modifier = modifier.padding(2.dp)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(
    modifier: Modifier = Modifier,
    title: String = "",
    imageVector: ImageVector,
    onIconClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = {
            if (title != "") {
                Text(text = title)
            }
        },
        actions = {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notifications",
                modifier = Modifier.padding(end = 12.dp),
                tint = Primary
            )
        },
        navigationIcon = {
            IconButton(onClick = { onIconClick() }) {
                Icon(
                    imageVector = imageVector,
                    contentDescription = "navigationIcon"
                )
            }

        }
    )
}

@Composable
fun AlertCustom(
    modifier: Modifier = Modifier,
    title: AnnotatedString,
    dismiss: () -> Unit
) {
    Dialog(onDismissRequest = { dismiss() },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )

        ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .border(
                    width = 2.dp,
                    color = Color(0xFF7ED476),
                    shape = RoundedCornerShape(8.dp)
                )
                .background(Color(0xFFEBF6ED)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            IconButton(modifier = Modifier
                .align(Alignment.End),
                onClick = { dismiss() }) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close"
                )
            }
            ImageBasic(image = R.drawable.ecoeats_logo, description = "Eco Eats Logo")
            Text(
                text = title.text,style = TextStyle(
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 22.sp,
                )

            )
            SpacerComponent(modifier = Modifier.height(8.dp))
            ButtonBasic(text = "Aceptar"){
                dismiss()
            }
            SpacerComponent(modifier = Modifier.height(8.dp))
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//private fun AlertCustomPreview() {
//    AlertCustom(title = "Mensaje") {
//
//    }
//}













