package com.example.youtube.di

import com.example.youtube.ui.fragment.detail.DetailViewModel
import com.example.youtube.ui.fragment.playlists.PlaylistsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        PlaylistsViewModel(get())
    }

    viewModel {
        DetailViewModel(get())
    }
}