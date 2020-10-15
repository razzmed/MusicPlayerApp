package com.example.musicplayerapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayerapp.R
import com.example.musicplayerapp.model.PlayerModel
import com.example.musicplayerapp.ui.PlayerActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel> ()

    private lateinit var mainAdapter: PlayerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView()
        subscribeSongs()
        startMusicPlayer()
    }

    private fun recyclerView() {
        mainAdapter = PlayerAdapter()
        rv_main.apply { layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = mainAdapter
        }
    }
     private fun subscribeSongs() {
         viewModel.cover.observe(this, Observer {
             mainAdapter.update(it)
         })
     }

    private fun startMusicPlayer() {
        mainAdapter.setOnClick(object : PlayerAdapter.ClickListener {
            override fun click(item: PlayerModel) {
                PlayerActivity.instanceStart(this@MainActivity, item)
            }
        })
    }
}