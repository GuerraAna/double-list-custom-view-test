package com.example.double_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.double_list.databinding.ItemListBinding

internal class ListAdapter(
    private val items: List<ListEntry>
) : Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)

        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        items[position].let { item ->
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int = items.size
}
