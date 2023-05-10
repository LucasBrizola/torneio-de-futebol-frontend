package com.brizola.torneiofut.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brizola.torneiofut.databinding.FragmentMatchesBinding
import com.brizola.torneiofut.login.data.local.Match


class MatchesFragment : Fragment() {
    private lateinit var binding: FragmentMatchesBinding

    private val list = listOf(Match("ti20", "professores"), Match("te19", "ti21"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ListItemAdapter()
        binding.list.adapter = adapter

        adapter.setItems(list)
    }

companion object {
    fun newInstance() = MatchesFragment()
}
}