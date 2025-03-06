package com.alexismoraportal.grupojambeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.alexismoraportal.grupojambeeapp.components.LateralMenu
import com.alexismoraportal.grupojambeeapp.navigation.NavManager
import com.alexismoraportal.grupojambeeapp.ui.theme.GrupoJambeeAppTheme
import com.alexismoraportal.grupojambeeapp.viewModel.PropertiesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val viewModel : PropertiesViewModel by viewModels()

        setContent {
            GrupoJambeeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainViewContent(viewModel)
                }
            }
        }
    }
}

@Composable
fun MainViewContent(viewModel: PropertiesViewModel){

    val navController = rememberNavController()

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    LateralMenu(
        navController = navController,
        drawerState = drawerState
    ) {
        NavManager(navController, viewModel, drawerState)
    }
}
