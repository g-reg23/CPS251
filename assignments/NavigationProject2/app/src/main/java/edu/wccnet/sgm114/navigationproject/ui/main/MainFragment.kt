package edu.wccnet.sgm114.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavAction
import edu.wccnet.sgm114.navigationproject.R
import edu.wccnet.sgm114.navigationproject.databinding.MainFragmentBinding
import androidx.navigation.Navigation

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }
//    private var _binding: MainFragmentBinding? = null
//    private val binding =
    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        _binding = MainFragmentBinding.inflate(inflater, container, false)
//        return binding.root
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.button1.setOnClickListener {
            var action = MainFragmentDirections.mainToSecond("Image 1", R.drawable.android_image_1)
            Navigation.findNavController(it).navigate(action)
        }
        binding.button2.setOnClickListener {
            var action = MainFragmentDirections.mainToSecond("Image 2", R.drawable.android_image_2)
            Navigation.findNavController(it).navigate(action)
        }
        binding.button3.setOnClickListener {
            var action = MainFragmentDirections.mainToSecond("Image 3", R.drawable.android_image_3)
            Navigation.findNavController(it).navigate(action)
        }
        // TODO: Use the ViewModel

    }

}