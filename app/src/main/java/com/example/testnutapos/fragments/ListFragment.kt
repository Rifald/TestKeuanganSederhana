package com.example.testnutapos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testnutapos.ListAdapter
import com.example.testnutapos.R
import com.example.testnutapos.data.UangMasukViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    private lateinit var mUangMasukViewModel: UangMasukViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        //RecycleView
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //userviewmodel
        mUangMasukViewModel = ViewModelProvider(this).get(UangMasukViewModel::class.java)
        mUangMasukViewModel.readAllData.observe(viewLifecycleOwner, Observer { uangMasuk ->
            adapter.setData(uangMasuk) })
        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }

}