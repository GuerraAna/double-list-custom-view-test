package com.example.double_list

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.double_list.databinding.ItemListBinding

internal class ListViewHolder(
    private val binding: ItemListBinding
) : ViewHolder(binding.root) {

    fun bind(listInfo: ListEntry) {
        binding.cardQuestionTitle.text = "title"
        binding.cardQuestionDescription.text = "description"
    }
}