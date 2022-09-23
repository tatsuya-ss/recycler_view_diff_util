package com.example.recycler_view_diff_util

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler_view_diff_util.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var currentNumber = 0
    private var numbersList = mutableListOf<Int>()
    private val adapter = NumberAdapter(numbersList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setNumberList()

        setupRecyclerView()

        binding.addButton.setOnClickListener {
            val oldNumbers = numbersList
            currentNumber += 5
            setNumberList()
            val newNumbers = numbersList
            val result = DiffUtil.calculateDiff(DiffCallBack(oldNumbers, newNumbers))
            adapter.list = newNumbers
            result.dispatchUpdatesTo(adapter)
        }
    }

    private fun setNumberList() {
        numbersList = mutableListOf()
        (0..currentNumber).forEach {
            numbersList.add(it)
        }
    }

    private fun setupRecyclerView() {
        binding.numbersRecyclerView.adapter = adapter
        binding.numbersRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}
