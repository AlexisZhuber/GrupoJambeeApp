package com.alexismoraportal.grupojambeeapp.model

data class SinglePropertyModel(
    val public_id: String,
    val title: String,
    val description: String,
    val bedrooms: Float,
    val bathrooms: Float,
    val half_bathrooms: Float,
    val parking_spaces: Float,
    val lot_size: Float,
    val construction_size: Float,
    val lot_length: Float?,
    val lot_width: Float?,
    val property_type: String,
    val created_at: String,
    val updated_at: String,
    val published_at: String,
    val location: LocationInfo, // Propiedad location agregada
    val operations: List<Operation>, // Propiedad operations agregada
    val property_images: List<PropertyImage>
)

data class LocationInfo(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val street: String,
    val postal_code: String,
    val show_exact_location: Boolean,
    val hide_exact_location: Boolean,
    val exterior_number: String,
    val interior_number: String
)

data class PropertyImage(
    val title: String?,
    val url: String
)


/*EJEMPLO API
{
  "public_id": "EB-OU2662",
  "title": "CASA EN VENTA EN QUERETARO",
  "description": "CASA EN RESIDENCIAL VIÑEDOS DEL POLO\nP R E V E N T A: $ 1 0, 5 5 0, 0 0 0\nV E N T A: $ 1 1, 3 0 0, 0 0 0 (a partir de marzo)\n\nEn el primer desarrollo campestre en su tipo con el objetivo de crear la comunidad con mayor calidad de vida de México. Apostando por un diseño y arquitectura sofisticada e integrada a un entorno natural de 80 hectáreas con 50% de áreas verdes. Es el lienzo perfecto para hacer de lo cotidiano, un estilo de vida extraordinario.\n\nEn planta baja: \nFamily room \nMedio baño\nCocina equipada\nSala - comedor\nTerraza Techada\nCuarto de Servicio\nCuarto de Lavado\nEstacionamiento techado 2 autos\n\nEn su segunda planta:\nHabitaciones principales con vestidor con zona húmeda para él y ella  \nDos habitaciones secundarias con baño completo, closets y balcón.\n\nEl fraccionamiento cuenta con diferentes amenidades como canchas de Polo, Pista de Salto, Viñedo, Casa Club y Spa, Zona de Playa y Remo, Pesca, Ski, Golf, Tenis y Padel.\n\nEsta casa es ideal para vivir en armonía y tranquilidad.\n\nSi necesitas asistencia o tienes alguna pregunta, no dudes en ponerte en contacto con nosotros.\n*Agencia Inmobiliaria*\n*Precio sujeto a cambios sin previo aviso*",
  "bedrooms": 3,
  "bathrooms": 3,
  "half_bathrooms": 1,
  "parking_spaces": 2,
  "lot_size": 684,
  "construction_size": 314,
  "lot_length": 0,
  "lot_width": 0,
  "floors": null,
  "floor": null,
  "age": null,
  "internal_id": null,
  "expenses": null,
  "location": {
    "name": "Viñedos, Tequisquiapan, Querétaro",
    "latitude": 20.5187326,
    "longitude": -99.8850586,
    "street": "",
    "postal_code": "76249",
    "show_exact_location": true,
    "hide_exact_location": false,
    "exterior_number": "",
    "interior_number": ""
  },
  "property_type": "Casa en condominio",
  "created_at": "2023-11-07T17:38:42-06:00",
  "updated_at": "2023-12-30T19:35:22-06:00",
  "published_at": "2023-12-16T20:05:49-06:00",
  "operations": [
    {
      "type": "sale",
      "amount": 10550000,
      "currency": "MXN",
      "formatted_amount": "$10,550,000",
      "commission": {
        "type": "percentage",
        "value": "4.0"
      },
      "unit": "total"
    }
  ],
  "property_files": [],
  "videos": [],
  "virtual_tour": null,
  "collaboration_notes": null,
  "public_url": "https://www.easybroker.com/mx/inmueble/casa-en-venta-en-queretaro-vinedos-tequisquiapan",
  "tags": [],
  "show_prices": true,
  "share_commission": true,
  "property_images": [
    {
      "title": null,
      "url": "https://assets.easybroker.com/property_images/4112662/68080295/EB-OU2662.png?version=1699400346"
    },
    {
      "title": null,
      "url": "https://assets.easybroker.com/property_images/4112662/68080296/EB-OU2662.png?version=1699400346"
    },
    {
      "title": null,
      "url": "https://assets.easybroker.com/property_images/4112662/68080297/EB-OU2662.png?version=1699400346"
    },
    {
      "title": null,
      "url": "https://assets.easybroker.com/property_images/4112662/68080302/EB-OU2662.png?version=1699400348"
    },
    {
      "title": null,
      "url": "https://assets.easybroker.com/property_images/4112662/68080303/EB-OU2662.png?version=1699400348"
    },
    {
      "title": null,
      "url": "https://assets.easybroker.com/property_images/4112662/68080305/EB-OU2662.png?version=1699400348"
    },
    {
      "title": null,
      "url": "https://assets.easybroker.com/property_images/4112662/68080307/EB-OU2662.png?version=1699400349"
    },
    {
      "title": null,
      "url": "https://assets.easybroker.com/property_images/4112662/68080309/EB-OU2662.png?version=1699400349"
    }
  ],
  "agent": {
    "id": 60777,
    "name": "JAQUELINE ROCHE",
    "full_name": "JAQUELINE ROCHE",
    "mobile_phone": "+524421492146",
    "profile_image_url": "https://assets.easybroker.com/profile_images/60777/JAQUELINE_ROCHE___scaled_.jpg",
    "email": "jroche@grupojaambe.com"
  },
  "features": []
}
*/