package com.alexismoraportal.grupojambeeapp.data

import com.alexismoraportal.grupojambeeapp.model.PropertiesModel
import com.alexismoraportal.grupojambeeapp.model.SinglePropertyModel
import com.alexismoraportal.grupojambeeapp.util.Constants.Companion.ENDPOINT_PROPERTIES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEasy {

    @GET(ENDPOINT_PROPERTIES)
    suspend fun getProperties() : Response<PropertiesModel>

    @GET(ENDPOINT_PROPERTIES)
    suspend fun getPropertiesPaging(@Query("page") page: Int, @Query("limit") pageSize: Int) : PropertiesModel

    @GET("$ENDPOINT_PROPERTIES/{id}")
    suspend fun getPropertyById(@Path(value = "id")id: String): Response<SinglePropertyModel>

    //@GET(ENDPOINT_PROPERTIES)
    //suspend fun getPropertiesByType(@Path(value = "name")name: String): Response<SinglePropertyModel>

}