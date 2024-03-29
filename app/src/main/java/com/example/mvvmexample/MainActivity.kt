package com.example.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmexample.databinding.ActivityMainBinding
import com.example.mvvmexample.network.data.Result
import com.example.mvvmexample.ui.CustomAdapter
import com.example.mvvmexample.viewmodel.CustomViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel:CustomViewModel = ViewModelProvider(this).get(CustomViewModel::class.java)
        viewModel.data.observe(this, Observer {
            prepareRecyclerView(it)
        })
    }
    fun prepareRecyclerView(results: List<Result>) {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CustomAdapter(results)
        binding.recyclerView.adapter = adapter
    }
}