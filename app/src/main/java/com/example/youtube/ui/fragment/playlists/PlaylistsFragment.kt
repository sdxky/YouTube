package com.example.youtube.ui.fragment.playlists

import androidx.fragment.app.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtube.databinding.FragmentPlaylistsBinding
import com.example.youtube.utils.Resource
import com.example.youtubeapi.ui.base.BaseFragment

class PlaylistsFragment :
    BaseFragment<FragmentPlaylistsBinding>(FragmentPlaylistsBinding::inflate) {

    private val viewModel: PlaylistsViewModel by viewModels()
    private val playlistsAdapter: PlaylistsAdapter by lazy { PlaylistsAdapter() }


    override fun setupViews() {
        super.setupViews()
        setupRecycler()
    }

    override fun setupObservers() {
        viewModel.getPlaylists().stateHandler(
            success = { data ->
                playlistsAdapter.submitList(data)
            },
            state = { state ->
                binding.progressBar.isVisible = state is Resource.Loading
            }
        )
    }

    private fun setupRecycler() = with(binding.recyclerView) {
        adapter = playlistsAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}

