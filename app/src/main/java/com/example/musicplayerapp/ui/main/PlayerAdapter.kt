package com.example.musicplayerapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayerapp.R
import com.example.musicplayerapp.extension.loadImage
import com.example.musicplayerapp.model.PlayerModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item.view.*

class PlayerAdapter : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> () {

    private val list = mutableListOf<PlayerModel>()
    private lateinit var clickListener: ClickListener

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            clickListener.click(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    fun update (list: MutableList<PlayerModel>) {
            this.list.addAll(list)
            notifyDataSetChanged()
        }

    fun setOnClick(clickListener: ClickListener) {
        this.clickListener =clickListener
    }

    class PlayerViewHolder(override val containerView: View) :
            RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun onBind(playerModel: PlayerModel) {
            itemView.circle_image_view.loadImage(playerModel.coverImage, R.drawable.ic_song_image)
            itemView.tv_singer_name.text = playerModel.artists
            itemView.tv_song_name.text = playerModel.song
        }
    }

    interface ClickListener {
        fun click(item: PlayerModel)
    }
}