package com.alexismoraportal.grupojambeeapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexismoraportal.grupojambeeapp.ui.theme.mainTopBarColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    title: String,
    showBackButton: Boolean = false,
    onClickBackButton: () -> Unit,
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()
    // Flag para evitar múltiples clics consecutivos en el botón de "back"
    var isBackButtonClicked by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = mainTopBarColor
        ),
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = {
                    if (!isBackButtonClicked) {
                        isBackButtonClicked = true
                        onClickBackButton()
                        // Reinicia el flag después de un breve retardo (por ejemplo, 300 ms)
                        scope.launch {
                            delay(300)
                            isBackButtonClicked = false
                        }
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back button",
                        tint = Color.White
                    )
                }
            } else {
                IconButton(onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu icon",
                        tint = Color.White
                    )
                }
            }
        }
    )
}
