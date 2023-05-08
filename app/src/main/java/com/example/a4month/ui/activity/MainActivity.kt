package com.example.a4month.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a4month.R
import com.example.a4month.data.NoteAdapter
import com.example.a4month.data.model.NoteModel
import com.example.a4month.databinding.ActivityMainBinding
import com.example.a4month.ui.fragment.addnote.AddNoteFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    val adapter = NoteAdapter(this, ArrayList())
    val selectedList = ArrayList<NoteModel>()

    val list : MutableList<NoteModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun addSelected(note: NoteModel){
        selectedList.add(note)
    }
    fun removeSelected(note: NoteModel){
        selectedList.remove(note)
    }
    fun clearSelected(note: NoteModel){
        selectedList.clear()
    }

    fun select(selectedList: ArrayList<NoteModel>){
        this.selectedList.clear()
        this.selectedList.addAll(selectedList)

    }


    private fun init(){
        binding.apply {
            imageBtn.setOnClickListener{
                val addFragment = AddNoteFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("selectedList", selectedList)
                addFragment.arguments = bundle
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, addFragment)
                    .commit()
                clearSelected()
            }
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recyclerView.adapter = adapter
            val note =NoteModel("", "","", R.drawable.img)
            val note1 =NoteModel("", "","", R.drawable.img1)
            val note2 =NoteModel("", "","", R.drawable.img2)
            val note3 =NoteModel("", "","", R.drawable.img3)
            val note4 =NoteModel("", "","", R.drawable.img4)
            val note5 =NoteModel("", "","", R.drawable.img5)
            val note6 =NoteModel("", "","", R.drawable.img6)
            val note7 =NoteModel("", "","", R.drawable.img7)
            val note8 =NoteModel("", "","", R.drawable.img8)
            val note9 =NoteModel("", "","", R.drawable.img9)
            val note10 =NoteModel("", "","", R.drawable.img10)
            val note11 =NoteModel("", "","", R.drawable.img11)


            adapter.addNote(note)
            adapter.addNote(note1)
            adapter.addNote(note2)
            adapter.addNote(note3)
            adapter.addNote(note4)
            adapter.addNote(note5)
            adapter.addNote(note6)
            adapter.addNote(note7)
            adapter.addNote(note8)
            adapter.addNote(note9)
            adapter.addNote(note10)
            adapter.addNote(note11)
        }
    }

    }

