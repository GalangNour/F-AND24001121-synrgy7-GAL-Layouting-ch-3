package com.example.challenge_ch3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge_ch3.databinding.AlphabetItemBinding

class Adapter : RecyclerView.Adapter<Adapter.AdapterViewHolder>() {
    private var dataList: List<String> = emptyList()
    private var itemClickListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val binding = AlphabetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun submitData(data: List<String>) {
        dataList = data
    }

    fun setOnItemClickListener(listener: (String) -> Unit) {
        itemClickListener = listener
    }

    inner class AdapterViewHolder(private val binding: AlphabetItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener?.invoke(dataList[position])
                }
            }
        }

        fun bind(item: String) {
            binding.tvAlphabet.text = item
        }
    }
}
