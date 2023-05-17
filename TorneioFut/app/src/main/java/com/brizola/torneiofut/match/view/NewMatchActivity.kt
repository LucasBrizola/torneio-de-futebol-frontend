package com.brizola.torneiofut.match.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.brizola.torneiofut.databinding.ActivityNewMatchBinding
import com.brizola.torneiofut.home.view.HomeActivity
import com.brizola.torneiofut.match.presentation.NewMatchViewModel
import com.brizola.torneiofut.match.presentation.ViewState

class NewMatchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewMatchBinding

    private val viewModel: NewMatchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configSaveButton()

        viewModel.viewState.observe(this) { state ->
            when (state) {
                is ViewState.ShowErrorNull -> toastFieldsNull()
                is ViewState.ShowSuccess -> save()
            }
        }
    }

    private fun configSaveButton() {
        binding.btnSave.setOnClickListener {
            viewModel.validateFields(
                name = binding.name.text.toString(),
                team1 = binding.team1.text.toString(),
                team2 = binding.team2.text.toString(),
                goal1 = binding.goalsField1.text.toString(),
                goal2 = binding.goalsField2.text.toString(),
                hour = binding.hourField.text.toString(),
            )
        }
    }

    private fun toastFieldsNull() {
        Toast.makeText(this, "preencha todos os campos!", Toast.LENGTH_LONG).show()
    }

    private fun save() {
        Toast.makeText(this, "partida salva!", Toast.LENGTH_LONG).show()
        startActivity(Intent(this@NewMatchActivity, HomeActivity::class.java))
    }
}