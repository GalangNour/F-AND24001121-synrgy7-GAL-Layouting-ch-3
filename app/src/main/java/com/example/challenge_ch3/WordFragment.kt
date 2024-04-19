package com.example.challenge_ch3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge_ch3.databinding.FragmentWordBinding
import androidx.navigation.fragment.findNavController


class WordFragment : Fragment() {
    private var _binding: FragmentWordBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: Adapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = Adapter()

        val params = arguments?.getString("PARAMS")
        var dataList = arrayListOf<String>()

        when (params) {
            Words.A.alphabet -> { dataList = Words.A.words }
            Words.B.alphabet -> { dataList = Words.B.words }
            Words.C.alphabet -> { dataList = Words.C.words }
            Words.D.alphabet -> { dataList = Words.D.words }
            Words.E.alphabet -> { dataList = Words.E.words }
            Words.F.alphabet -> { dataList = Words.F.words }
            Words.G.alphabet -> { dataList = Words.G.words }
            Words.H.alphabet -> { dataList = Words.H.words }
            Words.I.alphabet -> { dataList = Words.I.words }
            Words.J.alphabet -> { dataList = Words.J.words }
            Words.K.alphabet -> { dataList = Words.K.words }
            Words.L.alphabet -> { dataList = Words.L.words }
            Words.M.alphabet -> { dataList = Words.M.words }
            Words.N.alphabet -> { dataList = Words.N.words }
            Words.O.alphabet -> { dataList = Words.O.words }
            Words.P.alphabet -> { dataList = Words.P.words }
            Words.Q.alphabet -> { dataList = Words.Q.words }
            Words.R.alphabet -> { dataList = Words.R.words }
            Words.S.alphabet -> { dataList = Words.S.words }
            Words.T.alphabet -> { dataList = Words.T.words }
            Words.U.alphabet -> { dataList = Words.U.words }
            Words.V.alphabet -> { dataList = Words.V.words }
            Words.W.alphabet -> { dataList = Words.W.words }
            Words.X.alphabet -> { dataList = Words.X.words }
            Words.Y.alphabet -> { dataList = Words.Y.words }
            Words.Z.alphabet -> { dataList = Words.Z.words }
        }

        adapter.submitData(dataList)

        adapter.setOnItemClickListener { word ->
            val searchUri = Uri.parse("https://www.google.com/search?q=$word")
            val intent = Intent(Intent.ACTION_VIEW, searchUri)
            startActivity(intent)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.toolbar.topAppBar.title = "Words That Start With $params"
        binding.toolbar.topAppBar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        binding.toolbar.topAppBar.menu.clear()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}