package com.alexismoraportal.grupojambeeapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alexismoraportal.grupojambeeapp.model.PropertyList
import com.alexismoraportal.grupojambeeapp.repository.PropertiesRepository

class PropertyDataSource(private val repo: PropertiesRepository): PagingSource<Int, PropertyList>() {
    override fun getRefreshKey(state: PagingState<Int, PropertyList>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PropertyList> {
        return try {
            val nextPageNumber = params.key ?: 1
            val reponse = repo.getPropertiesPaging(nextPageNumber, 6)
            LoadResult.Page(
                data = reponse.content,
                prevKey = null,
                nextKey = if (reponse.content.isNotEmpty()) nextPageNumber + 1 else null
            )
        }catch (e: Exception){
            PagingSource.LoadResult.Error(e)
        }
    }

}