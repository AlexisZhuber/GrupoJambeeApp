package com.alexismoraportal.grupojambeeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.alexismoraportal.grupojambeeapp.R
import com.alexismoraportal.grupojambeeapp.model.ItemsLateralMenu
import com.alexismoraportal.grupojambeeapp.ui.theme.mainTopBarColor
import com.alexismoraportal.grupojambeeapp.ui.theme.selectedColorDrawer
import com.alexismoraportal.grupojambeeapp.ui.theme.whatsAppColor
import kotlinx.coroutines.launch

@Composable
fun LateralMenu(
    navController: NavController,
    drawerState: DrawerState,
    content: @Composable () -> Unit
){

    val menuItems = listOf(
        ItemsLateralMenu.ItemLateralMenu1,
        ItemsLateralMenu.ItemLateralMenu2,
        ItemsLateralMenu.ItemLateralMenu3,
    )

    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Image(
                    modifier = Modifier
                        .padding(15.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null)
                menuItems.forEach { item ->
                    NavigationDrawerItem(
                        label = { Text(text = item.title) },
                        selected = CurrentRoute(navController) == item.ruta,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(item.ruta)
                        },
                        icon = {
                            Image(painter = painterResource(id = item.icon), contentDescription = null)
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = selectedColorDrawer
                        )
                        )
                }
                Text(
                    text = "grupojaambe.com",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 10.dp),
                    textAlign = TextAlign.End, // Alinea el texto a la derecha
                    style = TextStyle(
                        color = Color.Gray, // Color del texto en gris
                        fontSize = 12.sp // Tamaño del texto más pequeño
                    )
                )
            }
        }
    ) {
        content()
    }
}

@Composable
fun CurrentRoute(navController: NavController) : String? =
    navController.currentBackStackEntryAsState().value?.destination?.route
