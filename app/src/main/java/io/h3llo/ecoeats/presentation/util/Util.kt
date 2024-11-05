package io.h3llo.ecoeats.presentation.util

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import java.io.ByteArrayOutputStream

object Util {

     fun getImageUri(data: Bitmap, context: Context) : Uri?{

         val byteArrayOutput = ByteArrayOutputStream()
         data.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutput)
         val path = MediaStore.Images.Media.insertImage(context.contentResolver,data,"Image", "")
         return Uri.parse(path)
     }
}