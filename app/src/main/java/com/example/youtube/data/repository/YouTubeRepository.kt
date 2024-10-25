package com.example.youtube.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtube.BuildConfig
import com.example.youtube.data.model.BaseResponse
import com.example.youtube.data.network.YouTubeApiService
import com.example.youtube.utils.Constants
import com.example.youtube.utils.Resource
import kotlinx.coroutines.Dispatchers

class YouTubeRepository(
    private val service: YouTubeApiService
) {

    fun getPlaylists(): LiveData<Resource<List<BaseResponse.Item>>> = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            val response = service.getPlaylists(
                apiKey = BuildConfig.API_KEY,
                part = Constants.PART,
                channelId = Constants.CHANNEL_ID,
                maxResults = Constants.MAX_RESULTS
            )
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Success(it.items))
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        }
    }
}