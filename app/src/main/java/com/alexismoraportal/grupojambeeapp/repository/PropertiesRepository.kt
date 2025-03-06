package com.alexismoraportal.grupojambeeapp.repository

import com.alexismoraportal.grupojambeeapp.data.ApiEasy
import com.alexismoraportal.grupojambeeapp.model.PropertiesModel
import com.alexismoraportal.grupojambeeapp.model.PropertyList
import com.alexismoraportal.grupojambeeapp.model.SinglePropertyModel
import javax.inject.Inject

class PropertiesRepository @Inject constructor(private val apiEasy: ApiEasy){

    suspend fun getProperties(): List<PropertyList>?{

        val response = apiEasy.getProperties()

        // Imprime el cuerpo de la respuesta directamente
        if (response.isSuccessful && response.body() != null) {
            return response.body()?.content
        } else {
            // Imprime el error en caso de que la respuesta no sea exitosa
            println("Error: ${response.errorBody()?.string()}")
            return null
        }

       /* if (respose.isSuccessful){
            return respose.body()?.results
        }*/
    }

    suspend fun getPropertiesPaging(page: Int, limit: Int): PropertiesModel{
        return apiEasy.getPropertiesPaging(page, limit)
    }

    suspend fun getPropertyById(id: String): SinglePropertyModel? {
        val reponse = apiEasy.getPropertyById(id)

        //println(reponse.body())

        if(reponse.isSuccessful){
            return reponse.body()
        }
        return null
    }

}