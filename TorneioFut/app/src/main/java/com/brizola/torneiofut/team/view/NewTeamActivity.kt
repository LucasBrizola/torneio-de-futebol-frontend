package com.brizola.torneiofut.team.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.brizola.torneiofut.databinding.ActivityNewTeamBinding
import com.brizola.torneiofut.team.presentation.NewTeamViewModel
import com.brizola.torneiofut.team.presentation.ViewState

class NewTeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewTeamBinding

    private val viewModel: NewTeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configSaveButton()

        viewModel.viewState.observe(this) { state ->
            when (state) {
                is ViewState.ShowErrorNameTeam -> toastNameNull()
                is ViewState.ShowErrorMinPlayer -> toastMinPlayer()
                is ViewState.ShowSuccess -> save()
            }
        }
    }

    private fun configSaveButton() {
        binding.btnSalvar.setOnClickListener {
            viewModel.createNewTeam(
                nameTeam = binding.nomeTime.text.toString(),
                num1 = binding.numJogador1.text.toString(),
                player1 = binding.jogador1.text.toString(),
                num2 = binding.numJogador2.text.toString(),
                player2 = binding.jogador2.text.toString(),
                num3 = binding.numJogador3.text.toString(),
                player3 = binding.jogador3.text.toString(),
                num4 = binding.numJogador4.text.toString(),
                player4 = binding.jogador4.text.toString(),
                num5 = binding.numJogador5.text.toString(),
                player5 = binding.jogador5.text.toString(),
                num6 = binding.numJogador6.text.toString(),
                player6 = binding.jogador6.text.toString(),
                num7 = binding.numJogador7.text.toString(),
                player7 = binding.jogador7.text.toString(),
                num8 = binding.numJogador8.text.toString(),
                player8 = binding.jogador8.text.toString(),
                num9 = binding.numJogador9.text.toString(),
                player9 = binding.jogador9.text.toString(),
                num10 = binding.numJogador10.text.toString(),
                player10 = binding.jogador10.text.toString(),
            )
        }
    }

    private fun toastNameNull() {
        Toast.makeText(this, "necessário informar um nome para o time", Toast.LENGTH_LONG).show()
    }

    private fun toastMinPlayer() {
        Toast.makeText(
            this,
            "é necessário no mínimo 5 jogadores para formar um time",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun save() {
        Toast.makeText(this, "Time salvo!", Toast.LENGTH_LONG).show()
        finish()
    }

}