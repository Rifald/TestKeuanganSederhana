package com.example.testnutapos.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testnutapos.R
import com.example.testnutapos.data.UangMasuk
import com.example.testnutapos.data.UangMasukViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {
    private lateinit var mUangMasukViewModel: UangMasukViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container,false)
        mUangMasukViewModel = ViewModelProvider(this).get(UangMasukViewModel::class.java)
        view.addButton.setOnClickListener{
            insertDataToDatabase()
        }

        return view



    }



    private fun insertDataToDatabase() {
        val terimaDari = addDari.text.toString()
        val keterangan = addKeterangan.text.toString()
        val jumlah = addjumlah.text

        if (inputCheck(terimaDari, keterangan, jumlah)) {
            //Create User Object
            val uangMasuk = UangMasuk(0, terimaDari, keterangan, Integer.parseInt(jumlah.toString()))

            mUangMasukViewModel.adddata(uangMasuk)
            Toast.makeText(requireContext(), "Successfully added!!!", Toast.LENGTH_SHORT).show()
            //Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_SHORT)
                .show()
        }

    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}