package com.example.catatan10120159.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.catatan10120159.AdapterListCatatan
import com.example.catatan10120159.DetailCatatanDialog
import com.example.catatan10120159.OnClickItemListener
import com.example.catatan10120159.database.AppDatabase
import com.example.catatan10120159.database.Note
import com.example.catatan10120159.databinding.FragmentCatatanBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatatanFragment : Fragment(), OnClickItemListener {
    private lateinit var binding: FragmentCatatanBinding

    private lateinit var database: AppDatabase
    private lateinit var adapter: AdapterListCatatan

    private var list = arrayListOf<Note>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatatanBinding.inflate(layoutInflater, container, false)

        database = AppDatabase.getAppDataBase(requireContext())!!


        adapter = AdapterListCatatan(requireContext(), this)
        binding.rvNote.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvNote.adapter = adapter

        getListCatatan()

        binding.btnAdd.setOnClickListener {
            DetailCatatanDialog(database, null, this).show(
                parentFragmentManager.beginTransaction(),
                "TambahCatatanDialog"
            )
        }



        return binding.root
    }

    private fun getListCatatan() {
        lifecycleScope.launch(Dispatchers.IO) {
            list.clear()
            val data = database.dataDao().getAllNote()

            list.addAll(data)

            println("list size = ${list.size}")

            requireActivity().runOnUiThread {

                adapter.setList(list)
            }
        }

    }

    override fun onEditNote(note: Note) {
        DetailCatatanDialog(database, note, this).show(
            parentFragmentManager.beginTransaction(),
            "TambahCatatanDialog"
        )
    }

    override fun onDeleteNote(note: Note) {
        lifecycleScope.launch(Dispatchers.IO) {
            database.dataDao().deleteNote(note)

            requireActivity().runOnUiThread {
                getListCatatan()
                Toast.makeText(
                    requireContext(),
                    "Berhasil Menghapus Catatan :)",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    override fun onUpdateNote() {
        getListCatatan()
    }

}

//Nim  : 10120159
//Nama : Muhammad Rizqy Akbar
//Kelas: IF-4
