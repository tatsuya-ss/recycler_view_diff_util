package com.example.recycler_view_diff_util

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler_view_diff_util.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var currentNumber = 10
    private var numberslist = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setNumberList()

        setupRecyclerView()

        setupRecyclerView()
    }

    private fun setNumberList() {
        (0..currentNumber).forEach {
            numberslist.add(it)
        }
    }

    private fun setupRecyclerView() {
        binding.numbersRecyclerView.adapter = NumberAdapter(numberslist)
        binding.numbersRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}