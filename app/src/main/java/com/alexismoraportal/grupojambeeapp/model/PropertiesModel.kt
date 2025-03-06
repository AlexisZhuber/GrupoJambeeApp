package com.alexismoraportal.grupojambeeapp.model

data class PropertiesModel(
    val content: List<PropertyList>
)

data class PropertyList(
    val public_id: String,
    val title: String,
    val title_image_full: String,
    val operations: List<Operation>
)

data class Operation(
    val type: String,
    val formatted_amount: String,
    val currency: String
)

/*EJEMPLO API
{
  "pagination": {
    "limit": 3,
    "page": 2,
    "total": 51,
    "next_page": "https://api.easybroker.com/v1/properties?limit=3&page=3"
  },
  "content": [
    {
      "public_id": "EB-OV1378",
      "title": "CASA EN VENTA EN QUERETARO SAN ISIDRO JURIQUILLA",
      "title_image_full": "https://assets.easybroker.com/property_images/4121378/68245924/EB-OV1378.jpg?version=1699766838",
      "title_image_thumb": "https://assets.easybroker.com/property_images/4121378/68245924/EB-OV1378_thumb.jpg?version=1699766838",
      "location": "San Isidro, Querétaro, Querétaro",
      "operations": [
        {
          "type": "sale",
          "amount": 2725779.85,
          "currency": "MXN",
          "formatted_amount": "$2,725,779.85",
          "commission": {
            "type": "percentage",
            "value": "3.0"
          },
          "unit": "total"
        }
      ],
      "bedrooms": 3,
      "bathrooms": 2,
      "parking_spaces": null,
      "property_type": "Casa",
      "lot_size": 113.14,
      "construction_size": 123.12,
      "updated_at": "2023-12-30T19:35:23-06:00",
      "agent": "JAQUELINE ROCHE",
      "show_prices": true,
      "share_commission": true
    },
    {
      "public_id": "EB-KG0771",
      "title": "CASA EN VENTA EN GRAND JURIQUILLA QUERÉTARO",
      "title_image_full": "https://assets.easybroker.com/property_images/2930771/46568468/EB-KG0771.jpg?version=1650998807",
      "title_image_thumb": "https://assets.easybroker.com/property_images/2930771/46568468/EB-KG0771_thumb.jpg?version=1650998807",
      "location": "Grand Juriquilla, Querétaro, Querétaro",
      "operations": [
        {
          "type": "sale",
          "amount": 3990000,
          "currency": "MXN",
          "formatted_amount": "$3,990,000",
          "commission": {
            "type": "percentage"
          },
          "unit": "total"
        }
      ],
      "bedrooms": 3,
      "bathrooms": 3,
      "parking_spaces": 3,
      "property_type": "Casa",
      "lot_size": 258,
      "construction_size": 200,
      "updated_at": "2023-12-30T19:35:24-06:00",
      "agent": "JAQUELINE ROCHE",
      "show_prices": true,
      "share_commission": false
    },
    {
      "public_id": "EB-MS1541",
      "title": "CASA EN VENTA EN QUERETARO",
      "title_image_full": "https://assets.easybroker.com/property_images/3571541/58113564/EB-MS1541.jpg?version=1677035265",
      "title_image_thumb": "https://assets.easybroker.com/property_images/3571541/58113564/EB-MS1541_thumb.jpg?version=1677035265",
      "location": "Cañadas del Arroyo, Corregidora, Querétaro",
      "operations": [
        {
          "type": "sale",
          "amount": 2400000,
          "currency": "MXN",
          "formatted_amount": "$2,400,000",
          "commission": {
            "type": "percentage"
          },
          "unit": "total"
        }
      ],
      "bedrooms": 2,
      "bathrooms": 2,
      "parking_spaces": 2,
      "property_type": "Casa",
      "lot_size": 160,
      "construction_size": 110,
      "updated_at": "2023-12-30T19:35:24-06:00",
      "agent": "JAQUELINE ROCHE",
      "show_prices": true,
      "share_commission": false
    }
  ]
}
*/
