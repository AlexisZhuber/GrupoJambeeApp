package com.alexismoraportal.grupojambeeapp.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextDetails(key: String, desc: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth() // Asegura que el Row ocupe todo el ancho disponible
            .padding(10.dp), // Agrega un poco de espacio verticalmente para separación
        verticalAlignment = Alignment.CenterVertically // Alinea verticalmente los textos en el centro
    ) {
        Text(
            text = key,
            modifier = Modifier
                .weight(1f) // Da a este Text un peso para que tome una fracción del espacio disponible
                .padding(start = 16.dp), // Mantiene el padding izquierdo
            textAlign = TextAlign.Start, // Justifica el texto al inicio
            fontFamily = FontFamily.Monospace, // Utiliza una fuente Monospace para el key
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp, // Ligeramente reducido para mejorar la legibilidad
            color = Color.Black // Usa el color primario del tema para destacar el key
        )
        Text(
            text = desc,
            modifier = Modifier
                .weight(1f) // Igualmente da a este Text un peso para equilibrar el espacio
                .padding(end = 16.dp), // Añade padding al final para alineación
            textAlign = TextAlign.End, // Justifica el texto al final
            fontSize = 18.sp, // Mantiene el tamaño para coherencia
            color = Color.Black// Usa un color que contraste bien con el fondo para el desc
        )
    }
}