package com.brizola.torneiofut.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.brizola.torneiofut.databinding.FragmentMatchesBinding
import com.brizola.torneiofut.home.presentation.MatchesFragmentViewModel
import com.brizola.torneiofut.home.presentation.ViewState
import com.brizola.torneiofut.match.domain.data.local.Match


class MatchesFragment : Fragment() {
    private lateinit var binding: FragmentMatchesBinding
    private val adapter by lazy {
        ListItemAdapter()
    }

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(MatchesFragmentViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = adapter
        viewModel.populateRecyclerView()
        viewModel.viewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.ShowMatchList -> addItems(state.matchList)
                is ViewState.ShowListEmpty -> recyclerIsEmpty()
            }
        }
    }

    private fun addItems(characterList: List<Match>) {
        adapter.setItems(characterList)
    }

    private fun recyclerIsEmpty() {
        Toast.makeText(requireContext(), "Recycler is empty.", Toast.LENGTH_LONG).show()
    }

companion object {
    fun newInstance() = MatchesFragment()
}
}