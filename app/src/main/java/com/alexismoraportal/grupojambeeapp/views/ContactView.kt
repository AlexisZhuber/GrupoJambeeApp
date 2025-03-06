package com.alexismoraportal.grupojambeeapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alexismoraportal.grupojambeeapp.components.AnimatedSectionTitle
import com.alexismoraportal.grupojambeeapp.components.MainTopBar
import com.alexismoraportal.grupojambeeapp.components.SendWhatsApp
import com.alexismoraportal.grupojambeeapp.components.WebsiteButton
import com.alexismoraportal.grupojambeeapp.ui.theme.selectedColorDrawer

@Composable
fun ContactView(navController: NavController, drawerState: DrawerState){

    Scaffold(
        topBar = {
            MainTopBar(title = "GRUPO JAAMBE", onClickBackButton = { /*TODO*/ }, drawerState = drawerState)
        }
    ) {
        ContentContactView(it, navController)
    }
}

@Composable
fun ContentContactView(paddingValues: PaddingValues, navController: NavController){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        item {
            AnimatedSectionTitle("Contàctanos | Grupo Jaambe Querétaro")
            Text(
                text = "Asesoría gratuita para nuestros clientes que están pensando en comprar o invertir en una propiedad en corto o mediano plano en la ciudad de Querétaro y área metropolitana.",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), // Agrega un padding para un mejor diseño
                textAlign = TextAlign.Justify, // Justifica el texto, // Usa una fuente Serif para un aspecto más elegante
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ) // Ajusta el tamaño de la fuente a tu preferencia
            AnimatedSectionTitle("Nuestro equipo de poder:")
            Text(
                text = "Broker Hipotecario,\n" +
                        "\n" +
                        "Póliza Jurídica,\n" +
                        "\n" +
                        "Contador,\n" +
                        "\n" +
                        "Notarias Publicas...\n" +
                        "\n" +
                        "Y muchas alianzas más, que nos permiten darte un servicio integral y eficaz.\n" +
                        "Licencia ante Desarrollo Urbano número AI-00299.\n" +
                        "Protección de la privacidad de los datos confidenciales que se nos faciliten.",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), // Agrega un padding para un mejor diseño
                textAlign = TextAlign.Justify, // Justifica el texto, // Usa una fuente Serif para un aspecto más elegante
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ) // Ajusta el tamaño de la fuente a tu preferencia
            Spacer(modifier = Modifier.height(16.dp))
            ContactCard()
            Spacer(modifier = Modifier.height(16.dp))
            SendWhatsApp("¡Hola! Me gustaría obtener más información.")
            Spacer(modifier = Modifier.height(16.dp))
            WebsiteButton()
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

@Composable
fun ContactCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = selectedColorDrawer
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text("Información de Contacto", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text("Email: jroche@grupojaambe.com")
            Text("Llamadas y WhatsApp: 4421492146 ")
        }
    }
}