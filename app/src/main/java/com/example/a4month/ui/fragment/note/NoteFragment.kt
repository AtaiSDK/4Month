package com.example.a4month.ui.fragment.note

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.a4month.R
import com.example.a4month.base.BaseFragment
import com.example.a4month.data.NoteAdapter
import com.example.a4month.data.model.NoteModel
import com.example.a4month.databinding.FragmentNoteBinding

class NoteFragment : BaseFragment<FragmentNoteBinding>(FragmentNoteBinding::inflate), NoteAdapter.Result {
    val adapter = NoteAdapter(this)
    val list = ArrayList<Int>()
    val images = ArrayList<Int>()


    override fun init(){
        binding.apply {

            imageBtn.setOnClickListener {
                val bundle = Bundle()
                bundle.putIntegerArrayList("images", images)
                findNavController().navigate(R.id.addNoteFragment, bundle)
            }
            recyclerView.adapter = adapter

            list.add(R.drawable.img)
            list.add(R.drawable.img1)
            list.add(R.drawable.img2)
            list.add(R.drawable.img3)
            list.add(R.drawable.img4)
            list.add(R.drawable.img5)
            list.add(R.drawable.img6)
            list.add(R.drawable.img7)
            list.add(R.drawable.img8)
            list.add(R.drawable.img9)
            list.add(R.drawable.img9)
            list.add(R.drawable.img10)
            list.add(R.drawable.img10)
            list.add(R.drawable.img11)
            list.add(R.drawable.img11)



            adapter.addNote(list)

        }
    }

    override fun setupUI() {
    }

    override fun images(image: Int) {
        if (images.contains(image)) {
            images.remove(image)
        } else {
            images.add(image)
        }
    }
}