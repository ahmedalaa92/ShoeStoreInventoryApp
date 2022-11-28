package com.example.shoestoreinventoryapp.screens.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestoreinventoryapp.R
import com.example.shoestoreinventoryapp.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding
    private lateinit var instructionsViewModel: InstructionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        instructionsViewModel = ViewModelProvider(this)[InstructionsViewModel::class.java]
        binding.instructionsViewModel = instructionsViewModel
        binding.lifecycleOwner = this

        instructionsViewModel.navigateToShoeListScreen.observe(viewLifecycleOwner) { shouldNavigateToShoeListScreen ->
            if (shouldNavigateToShoeListScreen) {
                val action =
                    InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
                findNavController().navigate(action)
                instructionsViewModel.onNavigationDone()
            }
        }
        return binding.root
    }
}