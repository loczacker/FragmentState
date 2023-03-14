package com.rikkei.training.activity

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rikkei.training.activity.databinding.FragmentFirstBinding

class FragmentFirst : Fragment() {

    private lateinit var mediaPlayer: MediaPlayer

    private lateinit var binding: FragmentFirstBinding

    private var currentPosition: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mediaPlayer = MediaPlayer.create(activity,R.raw.banhmi)
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer.start()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mediaPlayer.pause()
        currentPosition = mediaPlayer.currentPosition
        outState.putInt("time", currentPosition)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt("time", currentPosition)
            mediaPlayer.seekTo(currentPosition)
            mediaPlayer.start()
        }
    }
}