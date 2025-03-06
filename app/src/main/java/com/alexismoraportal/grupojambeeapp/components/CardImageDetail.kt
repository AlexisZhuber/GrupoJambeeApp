package com.alexismoraportal.grupojambeeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberImagePainter

@Composable
fun CardImageDetail(url: String) {

    var openDialog by remember { mutableStateOf(false) }
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier

            .padding(10.dp)
            .shadow(8.dp, RoundedCornerShape(5.dp))
            .clickable { openDialog = true }
    ) {
        Box(modifier = Modifier.height(250.dp)) {
            MainImage(image = url)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f)),
                            startY = 100f
                        )
                    )
            )
        }
    }

    if (openDialog) {
        Dialog(onDismissRequest = { openDialog= false }) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.9f))
            ) {

                // Imagen con capacidad de zoom y movimiento
                Image(
                    painter = rememberImagePainter(data = url),
                    contentDescription = "Imagen detallada",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                        .graphicsLayer(
                            scaleX = scale,
                            scaleY = scale,
                            translationX = offset.x,
                            translationY = offset.y
                        )
                        .pointerInput(Unit) {
                            detectTransformGestures { _, pan, zoom, _ ->
                                // Actualiza la escala
                                scale *= zoom
                                // Actualiza el offset para permitir el movimiento
                                offset += pan
                            }
                        }
                )

                // Botón para cerrar el diálogo, colocado después de la imagen para asegurar que esté por encima en la pila
                IconButton(onClick = {
                    openDialog = false
                    println("Icono pulsado")
                }, modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp) // Añade un poco de padding para evitar que el botón se pegue demasiado al borde
                ) {
                    Icon(Icons.Filled.Close, contentDescription = "Cerrar", tint = Color.White)
                }
            }
        }
    }
}
