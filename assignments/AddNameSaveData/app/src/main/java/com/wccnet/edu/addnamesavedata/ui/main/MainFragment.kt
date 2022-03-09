package com.wccnet.edu.addnamesavedata.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wccnet.edu.addnamesavedata.databinding.MainFragmentBinding
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        if (viewModel.getNames().size > 0) {
            displayAllNames()
            if (binding.sortButton.visibility == View.INVISIBLE && viewModel.getNames().size > 1) {
                binding.sortButton.visibility = View.VISIBLE
                binding.reverseButton.visibility = View.VISIBLE
            }
        } else {
            binding.tvOne.text = "No names have been added"
        }
        binding.button.setOnClickListener {
            if (binding.editText.text.toString().isNotEmpty()) {
                viewModel.addName(binding.editText.text.toString())
                if (binding.sortButton.visibility == View.INVISIBLE && viewModel.getNames().size > 1) {
                    binding.sortButton.visibility = View.VISIBLE
                    binding.reverseButton.visibility = View.VISIBLE
                }
                displayAllNames()
                binding.editText.text.clear()
            }
        }
        binding.sortButton.setOnClickListener {
            viewModel.sort()
            displayAllNames()
        }
        binding.reverseButton.setOnClickListener {
            viewModel.sortDescend()
            displayAllNames()
        }

    }
    private fun displayAllNames() {
        var names = ""
        for (name in viewModel.getNames()) {
            names = "" + names + name + "\n"
        }
        binding.tvOne.text = names
    }
}