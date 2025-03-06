package com.alexismoraportal.grupojambeeapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.alexismoraportal.grupojambeeapp.data.PropertyDataSource
import com.alexismoraportal.grupojambeeapp.model.LocationInfo
import com.alexismoraportal.grupojambeeapp.model.Operation
import com.alexismoraportal.grupojambeeapp.model.PropertyList
import com.alexismoraportal.grupojambeeapp.repository.PropertiesRepository
import com.alexismoraportal.grupojambeeapp.state.PropertyState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PropertiesViewModel @Inject constructor(private val repo: PropertiesRepository) : ViewModel(){

    private val _properties = MutableStateFlow<List<PropertyList>>(emptyList())
    val properties = _properties.asStateFlow()

    var state by mutableStateOf(PropertyState())
        private set

    init {
        fetchProperties()
    }

    val propertiesPage = Pager(PagingConfig(pageSize = 6)){
        PropertyDataSource(repo)
    }.flow.cachedIn(viewModelScope)

    private fun fetchProperties(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = repo.getProperties()
                _properties.value = result ?: emptyList()
            }
        }
    }

    fun getPropertyById(id: String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = repo.getPropertyById(id)

                println(result?.property_images.toString())

                // Obtener la información de operaciones (type, currency y formatted_amount)
                val operations = result?.operations?.map { operation ->
                    Operation(
                        type = operation.type,
                        currency = operation.currency,
                        formatted_amount = operation.formatted_amount
                    )
                } ?: emptyList()

                // Obtener la información de ubicación
                val locationInfo = LocationInfo(
                    name = result?.location?.name ?: "",
                    latitude = result?.location?.latitude ?: 0.0,
                    longitude = result?.location?.longitude ?: 0.0,
                    street = result?.location?.street ?: "",
                    postal_code = result?.location?.postal_code ?: "",
                    show_exact_location = result?.location?.show_exact_location ?: false,
                    hide_exact_location = result?.location?.hide_exact_location ?: false,
                    exterior_number = result?.location?.exterior_number ?: "",
                    interior_number = result?.location?.interior_number ?: ""
                )

                state = state.copy(
                    publicId = result?.public_id ?: "",
                    title = result?.title ?: "",
                    description = result?.description ?: "",
                    bedrooms = result?.bedrooms ?: 0f,
                    bathrooms = result?.bathrooms ?: 0f,
                    halfBathrooms = result?.half_bathrooms ?: 0f,
                    parkingSpaces = result?.parking_spaces ?: 0f,
                    lotSize = result?.lot_size ?: 0f,
                    constructionSize = result?.construction_size ?: 0f,
                    lotLength = result?.lot_length,
                    lotWidth = result?.lot_width,
                    propertyType = result?.property_type ?: "",
                    createdAt = result?.created_at ?: "",
                    updatedAt = result?.updated_at ?: "",
                    publishedAt = result?.published_at ?: "",
                    propertyImages = result?.property_images ?: emptyList(),
                    operations = operations,
                    location = locationInfo
                 )
            }
        }
    }

    fun clean(){
        state = PropertyState()
    }

}