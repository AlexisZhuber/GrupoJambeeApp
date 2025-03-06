package com.alexismoraportal.grupojambeeapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alexismoraportal.grupojambeeapp.R
import com.alexismoraportal.grupojambeeapp.components.AnimatedSectionTitle
import com.alexismoraportal.grupojambeeapp.components.MainTopBar
import com.alexismoraportal.grupojambeeapp.components.TextDetails
import com.alexismoraportal.grupojambeeapp.ui.theme.selectedColorDrawer

@Composable
fun AboutView(navController: NavController, drawerState: DrawerState){

    Scaffold(
        topBar = {
            MainTopBar(title = "GRUPO JAAMBE", onClickBackButton = { /*TODO*/ }, drawerState = drawerState)
        }
    ) {
        ContentAboutView(it, navController)
    }
}

@Composable
fun ContentAboutView(paddingValues: PaddingValues, navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            AnimatedSectionTitle("Experiencia en el mercado")
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = selectedColorDrawer
                )
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Asesor Inmobiliario Certificado",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,)
                    Spacer(modifier = Modifier.height(8.dp))
                    TextDetails("Nombre:", "Jaqueline Roche Garcia")
                    TextDetails("Experiencia:", "7 años en el mercado inmobiliario")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(R.drawable.licencia),
                contentDescription = "Imagen inmobiliaria",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(R.drawable.actualizacion),
                contentDescription = "Imagen inmobiliaria",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}