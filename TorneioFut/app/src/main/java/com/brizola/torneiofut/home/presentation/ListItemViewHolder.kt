package com.brizola.torneiofut.home.presentation

import androidx.recyclerview.widget.RecyclerView
import com.brizola.torneiofut.databinding.ListItemBinding
import com.brizola.torneiofut.login.data.local.Match

class ListItemViewHolder (
    private val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
        fun bind(match: Match) {
            binding.tvTeam1.text = match.team1
            binding.tvTeam2.text = match.team2
        }
}