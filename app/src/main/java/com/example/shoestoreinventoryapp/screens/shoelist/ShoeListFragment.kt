package com.example.shoestoreinventoryapp.screens.shoelist

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestoreinventoryapp.R
import com.example.shoestoreinventoryapp.databinding.FragmentShoeListBinding
import com.example.shoestoreinventoryapp.models.Shoe
import kotlinx.android.synthetic.main.item_shoe.view.*

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        shoeListViewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java]
        binding.viewModel = shoeListViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        shoeListViewModel.navigationToAddItem.observe(viewLifecycleOwner) { shouldNavigateToAddItem ->
            if (shouldNavigateToAddItem) {
                val action = ShoeListFragmentDirections.actionShoeListFragmentToAddShoeFragment()
                findNavController().navigate(action)
                shoeListViewModel.onNavigationToAddItemDone()
            }
        }

        shoeListViewModel.shoeList.observe(viewLifecycleOwner) { newList ->
            populateShoeList(newList)
        }
        addMenuItem()
        return binding.root
    }

    private fun addMenuItem() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.item_logout, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == R.id.logout_item) {
                    val action = ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
                    findNavController().navigate(action)
                    return true
                }
                return false
            }
        }, viewLifecycleOwner)
    }


    private fun populateShoeList(newList: List<Shoe>) {
        for (shoe in newList) {
            val layoutContainer = LayoutInflater.from(context).inflate(R.layout.item_shoe, null)
            layoutContainer.shoeImage.setImageResource(R.drawable.ic_launcher_background)
            layoutContainer.shoeNameText.text = shoe.name
            layoutContainer.shoeSizeText.text = shoe.size.toString()
            layoutContainer.shoeCompanyText.text = String.format("Company: ${shoe.company}")
            layoutContainer.shoeDescriptionText.text = shoe.description
            binding.shoeListContainerLayout.addView(layoutContainer)
        }
    }
}