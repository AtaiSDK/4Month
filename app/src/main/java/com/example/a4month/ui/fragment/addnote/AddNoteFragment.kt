package com.example.a4month.ui.fragment.addnote

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.fragment.app.Fragment
import com.example.a4month.R
import com.example.a4month.base.BaseFragment
import com.example.a4month.data.NoteAdapter

import com.example.a4month.databinding.ActivityMainBinding.inflate
import com.example.a4month.databinding.FragmentAddNoteBinding
import com.example.a4month.databinding.FragmentAddNoteBinding.inflate


class AddNoteFragment : BaseFragment<FragmentAddNoteBinding>(FragmentAddNoteBinding::inflate), NoteAdapter.Result   {

    val adapter = NoteAdapter(this)



    override fun setupUI() {
        if (arguments != null) {
            val images = arguments?.getIntegerArrayList("images")

            images?.let { adapter.addNote(it) }
            binding.addRecyclerView.adapter = adapter
        }
    }

    override fun init() {
    }

    override fun images(image: Int) {

    }
}