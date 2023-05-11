package com.example.a4month.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.a4month.R
import com.example.a4month.databinding.ItemAdapterBinding

class NoteAdapter(private val click: Result): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    val noteList = ArrayList<Int>()
    val selectedImages = mutableListOf<Int>()


    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val noteItem = ItemAdapterBinding.bind(item)

        fun bind(image: Int) {
            noteItem.image.setImageResource(image)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(noteList[position])
        holder.noteItem.image.setOnClickListener{
            if (holder.noteItem.image.alpha == 1f) {
                holder.noteItem.image.alpha = 0.5f
            } else {
                holder.noteItem.image.alpha = 1.0f
            }
            click.images(noteList[position])
        }
    }

    override fun getItemCount(): Int {
        return noteList.size

    }
    fun addNote(note: ArrayList<Int>) {
        noteList.addAll(note)
        notifyDataSetChanged()
    }

    interface Result {
        fun images(image: Int)
    }
}