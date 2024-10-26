package com.example.youtube.ui.fragment.playlists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtube.data.model.Item
import com.example.youtube.databinding.ItemPlaylistBinding

class PlaylistsAdapter :
    ListAdapter<Item, PlaylistsAdapter.PlaylistViewHolder>(PlaylistItemCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlaylistViewHolder {
        return PlaylistViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class PlaylistViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(playlists: Item) {
            with(binding) {
                playlistName.text = playlists.snippet.title
                tvCount.text = playlists.contentDetails.itemCount.toString()
                image.load(playlists.snippet.thumbnails.medium.url)
            }
        }
    }
}

class PlaylistItemCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
}