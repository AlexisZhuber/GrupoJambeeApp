package com.alexismoraportal.grupojambeeapp.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alexismoraportal.grupojambeeapp.R
import com.alexismoraportal.grupojambeeapp.ui.theme.whatsAppColor

@Composable
fun SendWhatsApp(information: String) {


    val context = LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/+524421492146?text=$information"))
    // Define un color para el botón de WhatsApp, reemplaza esto con el color real de tu tema

    Column (modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {

        Button(onClick = {
            context.startActivity(intent)
        },
            modifier = Modifier.padding(bottom = 10.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = whatsAppColor
            )) {
            // Usa una fila para organizar el texto y el icono horizontalmente
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Contacto WhatsApp")
                // Agrega un pequeño espacio entre el texto y el icono
                Spacer(modifier = Modifier.width(4.dp))
                Icon(painter = painterResource(R.drawable.baseline_message_24), contentDescription = "WhatsApp Logo", modifier = Modifier.size(20.dp)) // Ajusta el tamaño según necesites
            }
        }
    }

}



