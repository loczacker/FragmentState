package com.rikkei.training.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rikkei.training.activity.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnA.setOnClickListener{
            viewFragment()
        }
    }

    private fun viewFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fm_a, FragmentFirst())
            .commit()
    }
}