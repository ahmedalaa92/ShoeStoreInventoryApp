package com.example.shoestoreinventoryapp.screens.addshoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestoreinventoryapp.R
import com.example.shoestoreinventoryapp.databinding.FragmentAddShoeBinding
import com.example.shoestoreinventoryapp.screens.shoelist.ShoeListViewModel

class AddShoeFragment : Fragment() {

    private lateinit var binding: FragmentAddShoeBinding
    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_shoe, container, false)
        viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.saveButton.setOnClickListener {
            viewModel.onSaveButtonClicked(
                binding.shoeNameEditText.text.toString(),
                binding.shoeSizeEditText.text.toString(),
                binding.shoeCompanyEditText.text.toString(),
                binding.shoeDescriptionEditText.text.toString()
            )
        }

        viewModel.navigationToShoeList.observe(viewLifecycleOwner) { shouldNavigateToShoeList ->
            if (shouldNavigateToShoeList) {
                val action = AddShoeFragmentDirections.actionAddShoeFragmentToShoeListFragment()
                findNavController().navigate(action)
                viewModel.onNavigationToShoeListDone()
            }
        }
        return binding.root
    }
}