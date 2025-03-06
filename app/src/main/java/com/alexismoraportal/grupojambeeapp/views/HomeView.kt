package com.alexismoraportal.grupojambeeapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.alexismoraportal.grupojambeeapp.components.CardProperty
import com.alexismoraportal.grupojambeeapp.components.Loader
import com.alexismoraportal.grupojambeeapp.components.MainTopBar
import com.alexismoraportal.grupojambeeapp.viewModel.PropertiesViewModel

@Composable
fun HomeView(viewModel: PropertiesViewModel, navController: NavController, drawerState: DrawerState){

    Scaffold(
        topBar = {
            MainTopBar(title = "GRUPO JAAMBE", onClickBackButton = { /*TODO*/ }, drawerState = drawerState)
        }
    ) {
        ContentHomeView(viewModel, it, navController)
    }

}

@Composable
fun ContentHomeView(viewModel: PropertiesViewModel, paddingValues: PaddingValues, navController: NavController){
    //val properties by viewModel.properties.collectAsState()
    val propertiesPage = viewModel.propertiesPage.collectAsLazyPagingItems()

    Column(
        modifier = Modifier.padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        LazyColumn{
            items(propertiesPage.itemCount){index ->

                val item = propertiesPage[index]

                if(item != null){

                    CardProperty(item){
                        navController.navigate("DetailView/${item.public_id}")
                        //avController.navigate("DetailView")
                        println("Id publico: " + item.public_id)
                        println("Tipo de la variable: ${item.public_id.javaClass.name}")
                    }

                    Text(

                        text = item.title.uppercase(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = if (item.operations.isNotEmpty())
                            "${item.operations.first().formatted_amount} ${item.operations.first().currency}"
                        else
                            "No disponible",
                        fontSize = 12.sp,
                        color = Color.DarkGray,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )


                    Divider(color = Color.LightGray, thickness = 1.dp)
                }
            }

            when(propertiesPage.loadState.append){
                is LoadState.NotLoading -> Unit
                LoadState.Loading -> {
                    item {
                        Column (
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Loader()
                        }
                    }
                }
                is LoadState.Error -> {
                    item{
                        Text(text = "Error")
                    }
                }

            }
        }
    }
}