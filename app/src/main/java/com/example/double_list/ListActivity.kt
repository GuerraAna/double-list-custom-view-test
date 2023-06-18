package com.example.double_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.double_list.databinding.ActivityListBinding

internal class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.list.title = "titulooo"
        binding.list.isLoading = false
    }
}