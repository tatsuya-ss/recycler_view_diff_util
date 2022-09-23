package com.example.recycler_view_diff_util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view_diff_util.databinding.AdapterNumberBinding

class NumberAdapter(val list: List<Int>) : RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val binding = AdapterNumberBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return NumberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.setup(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class NumberViewHolder(
        private val binding: AdapterNumberBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun setup(number: Int) {
            binding.numberTextView.text = number.toString()
        }
    }
}