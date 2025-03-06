package com.alexismoraportal.grupojambeeapp.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alexismoraportal.grupojambeeapp.components.AnimatedSectionTitle
import com.alexismoraportal.grupojambeeapp.components.CardImageDetail
import com.alexismoraportal.grupojambeeapp.components.MainTopBar
import com.alexismoraportal.grupojambeeapp.components.SendWhatsApp
import com.alexismoraportal.grupojambeeapp.components.TextDetails
import com.alexismoraportal.grupojambeeapp.viewModel.PropertiesViewModel

@Composable
fun DetailView(viewModel: PropertiesViewModel, navController: NavController, id: String, drawerState: DrawerState){

    LaunchedEffect(Unit){
         viewModel.getPropertyById(id)
    }

    DisposableEffect(Unit){
        onDispose {
            viewModel.clean()
        }
    }

    Scaffold(
        topBar = {
            MainTopBar(title = viewModel.state.title, onClickBackButton = { navController.popBackStack() }, showBackButton = true, drawerState = drawerState)
        }
    ) {
        ContentDetailView(it, viewModel)
    }

}

@Composable
fun ContentDetailView(pad: PaddingValues, viewModel: PropertiesViewModel) {
    val state = viewModel.state

    LazyColumn(
        modifier = Modifier
            .padding(pad)
    ) {
        item {

            AnimatedSectionTitle("Descripción")

            Text(
                text = state.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), // Agrega un padding para un mejor diseño
                textAlign = TextAlign.Justify, // Justifica el texto, // Usa una fuente Serif para un aspecto más elegante
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp, // Ajusta el tamaño de la fuente a tu preferencia
            )
            Divider(color = Color.LightGray, thickness = 1.dp)
        }

        state.operations?.let { ops ->
            item {
                AnimatedSectionTitle("Información")
                TextDetails("PRECIO: ", ops.joinToString(", ") { it.formatted_amount + " " + it.currency })
            }
        }

        state.location?.let { loc ->
            item {
                TextDetails("LOCACION: ", loc.name)
                if (loc.postal_code.isNotEmpty()) {
                    TextDetails("CODIGO POSTAL:", loc.postal_code)
                }
            }
        }

        item{
            if (state.bedrooms.toInt() > 0) {
                TextDetails("CUARTOS:", state.bedrooms.toInt().toString())
            }
            if (state.bathrooms.toInt() > 0) {
                TextDetails("BAÑOS:", state.bathrooms.toInt().toString())
            }
            if (state.halfBathrooms.toInt() > 0) {
                TextDetails("MEDIOS BAÑOS:", state.halfBathrooms.toInt().toString())
            }
            if (state.constructionSize > 0) {
                TextDetails("CONSTRUCCION:", "${state.constructionSize} m2")
            }
            if (state.lotSize > 0) {
                TextDetails("TERRENO:", "${state.lotSize} m2")
            }
            SendWhatsApp("Hola! estoy interesado en la siguiente propiedad: " + state.publicId)
            Divider(color = Color.LightGray, thickness = 1.dp)
            AnimatedSectionTitle("Galería")
        }

        state.propertyImages?.let { images ->
            items(images) { item ->
                CardImageDetail(url = item.url)
            }
        }
    }
}

