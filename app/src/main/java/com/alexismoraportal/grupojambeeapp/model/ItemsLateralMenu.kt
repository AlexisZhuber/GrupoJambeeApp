package com.alexismoraportal.grupojambeeapp.model

import com.alexismoraportal.grupojambeeapp.R

sealed class ItemsLateralMenu(
    val icon: Int,
    val title: String,
    val ruta: String
) {
    object ItemLateralMenu1 : ItemsLateralMenu(
        R.drawable.baseline_home_24,
        "Propiedades",
        "Home"
    )
    object ItemLateralMenu2 : ItemsLateralMenu(
        R.drawable.baseline_supervised_user_circle_24,
        "Acerca de",
        "About"
    )
    object ItemLateralMenu3 : ItemsLateralMenu(
        R.drawable.baseline_contact_page_24,
        "Contacto",
        "Contact"
    )
}