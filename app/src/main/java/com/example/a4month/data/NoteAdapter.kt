package com.example.a4month.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a4month.R
import com.example.a4month.data.model.NoteModel
import com.example.a4month.databinding.ItemAdapterBinding
import com.example.a4month.ui.activity.MainActivity

class NoteAdapter(private val listener: MainActivity, private val selectedList: ArrayList<NoteModel>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    val noteList = ArrayList<NoteModel>()
    val list : MutableList<NoteModel> = ArrayList()
    inner class ViewHolder(item: View):RecyclerView.ViewHolder(item) {
        val noteItem = ItemAdapterBinding.bind(item)


        fun bind(note: NoteModel){
            noteItem.image.setImageResource(note.imageView)

            if(selectedList.contains(note)){
                noteItem.image.alpha = 0.5f
            }else{
                noteItem.image.alpha = 1f
            }

            noteItem.image.setOnLongClickListener{
                if(selectedList.contains(note)){
                    selectedList.remove(note)
                    noteItem.image.alpha = 1f
                }else{
                    selectedList.add(note)
                    noteItem.image.alpha = 0.5f
                }
                listener.select(selectedList)
                return@setOnLongClickListener true
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(noteList[position])

    }
    interface SelectedListener{
        fun select(selectList: ArrayList<NoteModel>)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
    fun addNote(note: NoteModel){
        noteList.add(note)
        notifyDataSetChanged()
    }
}