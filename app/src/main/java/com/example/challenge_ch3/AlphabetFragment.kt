package com.example.challenge_ch3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge_ch3.databinding.FragmentAlphabetBinding




class AlphabetFragment : Fragment() {
    private var _binding: FragmentAlphabetBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: Adapter
    private val alphabetList = ('A'..'Z').map { it.toString() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlphabetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var isList = true

        adapter = Adapter()
        adapter.submitData(alphabetList)

        adapter.setOnItemClickListener { alphabet ->
            println("Selected alphabet: $alphabet")
            val action = AlphabetFragmentDirections.actionAlphabetFragmentToWordFragment(alphabet)
            findNavController().navigate(action)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.toolbar.topAppBar.setNavigationIcon(null)
        binding.toolbar.topAppBar.title = "LIST ALPHABET"
        binding.toolbar.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.grid -> {
                    isList = !isList
                    if (isList) {
                        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
                        binding.toolbar.topAppBar.title = "LIST ALPHABET"
                    } else {
                        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
                        binding.toolbar.topAppBar.title = "GRID ALPHABET"
                    }
                    true
                }
                else -> false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
