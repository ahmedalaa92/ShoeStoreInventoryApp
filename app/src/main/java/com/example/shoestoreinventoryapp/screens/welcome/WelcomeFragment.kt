package com.example.shoestoreinventoryapp.screens.welcome

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestoreinventoryapp.R
import com.example.shoestoreinventoryapp.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    private lateinit var welcomeViewModel: WelcomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        welcomeViewModel = ViewModelProvider(this)[WelcomeViewModel::class.java]
        binding.welcomeViewModel = welcomeViewModel
        binding.lifecycleOwner = this

        welcomeViewModel.navigateToInstructionsScreen.observe(viewLifecycleOwner) { shouldNavigateToInstructionsScreen ->
            if (shouldNavigateToInstructionsScreen) {
                val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
                findNavController().navigate(action)
                welcomeViewModel.onNavigationDone()
            }
        }
        return binding.root
    }
}