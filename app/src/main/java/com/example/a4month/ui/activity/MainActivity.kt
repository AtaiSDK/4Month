package com.example.a4month.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a4month.R
import com.example.a4month.data.NoteAdapter
import com.example.a4month.data.model.NoteModel
import com.example.a4month.databinding.ActivityMainBinding
import com.example.a4month.ui.fragment.addnote.AddNoteFragment
import com.example.a4month.ui.fragment.note.NoteFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val list : MutableList<NoteModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }



    }

