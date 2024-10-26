package com.example.youtube.ui.fragment.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtube.data.model.BaseResponse
import com.example.youtube.data.model.Item
import com.example.youtube.data.repository.YouTubeRepository
import com.example.youtube.utils.Resource

class PlaylistsViewModel(private val repository: YouTubeRepository): ViewModel() {
    fun getPlaylists():LiveData<Resource<List<Item>>> {
        return repository.getPlayLists()
    }
}