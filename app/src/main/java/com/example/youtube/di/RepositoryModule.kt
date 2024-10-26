package com.example.youtube.di

import com.example.youtube.data.repository.YouTubeRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory {
        YouTubeRepository(get())
    }
}