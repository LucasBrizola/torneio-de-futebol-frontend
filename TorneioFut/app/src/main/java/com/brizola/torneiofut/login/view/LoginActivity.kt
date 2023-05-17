package com.brizola.torneiofut.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.brizola.torneiofut.databinding.ActivityLoginBinding
import com.brizola.torneiofut.login.presentation.LoginViewModel
import com.brizola.torneiofut.login.presentation.ViewState
import com.brizola.torneiofut.match.view.NewMatchActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.viewState.observe(this) { state ->
            when (state) {
                is ViewState.ShowSuccess -> ShowSucess()
                is ViewState.ShowErrorLogin -> showErrorLogin()
                is ViewState.ShowFieldsNull -> showFieldsNull()
            }
        }
        configLoginButton()
    }

    private fun configLoginButton() {
        binding.btnLogin.setOnClickListener {
            viewModel.loginUser(
                name = binding.etName.text.toString(),
                password = binding.etPassword.text.toString()
            )
        }
    }

    private fun ShowSucess() {
        startActivity(Intent(this@LoginActivity, NewMatchActivity::class.java))
    }

    private fun showErrorLogin() {
        Toast.makeText(this, "login ou senha incorretos", Toast.LENGTH_LONG).show()
    }
    private fun showFieldsNull() {
        Toast.makeText(this, "campos não podem ser vazios", Toast.LENGTH_LONG).show()
    }

}