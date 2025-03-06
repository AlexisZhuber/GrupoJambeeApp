package com.alexismoraportal.grupojambeeapp.di

import com.alexismoraportal.grupojambeeapp.data.ApiEasy
import com.alexismoraportal.grupojambeeapp.util.Constants.Companion.API_KEY
import com.alexismoraportal.grupojambeeapp.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
// Define un objeto Kotlin que contendrá las funciones proveedoras de dependencias.
object AppModule {

    // Provee una instancia única de Retrofit para toda la aplicación.
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        // Crea un interceptor que interceptará todas las solicitudes salientes.
        val headerInterceptor = Interceptor { chain ->
            // Para cada solicitud, construye una nueva solicitud añadiendo un encabezado específico.
            val request = chain.request().newBuilder()
                .addHeader("accept", "application/json") // Añade el encabezado deseado.
                .addHeader("X-Authorization", API_KEY) // Añade el encabezado deseado.
                .build()
            // Continúa con la cadena de solicitud/respuesta.
            chain.proceed(request)
        }

        // Crea un cliente OkHttpClient y añade el interceptor.
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(headerInterceptor) // Añade el interceptor al cliente.
            .build()

        // Construye y retorna una instancia de Retrofit.
        return Retrofit.Builder()
            .baseUrl(BASE_URL) // Establece la URL base para las solicitudes HTTP.
            .client(okHttpClient) // Utiliza el cliente OkHttpClient personalizado.
            .addConverterFactory(GsonConverterFactory.create()) // Añade un convertidor de JSON para serialización/deserialización automática.
            .build() // Construye la instancia de Retrofit.
    }

    // Provee una instancia única de la interfaz API para toda la aplicación.
    @Singleton
    @Provides
    fun providesApiJaambe(retrofit: Retrofit): ApiEasy {
        // Crea y retorna una implementación de la interfaz ApiEasy usando Retrofit.
        return retrofit.create(ApiEasy::class.java)
    }

}
