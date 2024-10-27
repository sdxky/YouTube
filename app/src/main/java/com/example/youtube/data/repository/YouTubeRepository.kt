package com.example.youtube.data.repository

import androidx.lifecycle.LiveData
import com.example.youtube.BuildConfig
import com.example.youtube.data.base.BaseRepository
import com.example.youtube.data.model.BaseResponse
import com.example.youtube.data.model.Item
import com.example.youtube.data.network.YouTubeApiService
import com.example.youtube.utils.Constants
import com.example.youtube.utils.Resource
import retrofit2.Response



const val ARG_ERROR_MESSAGE = "Unknown Error"

class YouTubeRepository(
    private val api: YouTubeApiService
) : BaseRepository() {

    fun getPlayLists(): LiveData<Resource<List<Item>>> = sendRequest {
        val response: Response<BaseResponse> = api.fetchPlaylists(
            channelId = Constants.CHANNEL_ID,
            part = Constants.PART,
            maxResults = Constants.MAX_RESULTS,
            apiKey = BuildConfig.API_KEY
        )
        if (response.isSuccessful) {
            Response.success(response.body()?.items ?: emptyList())
        } else {
            Response.error(response.errorBody()!!, response.raw())
        }
    }
}