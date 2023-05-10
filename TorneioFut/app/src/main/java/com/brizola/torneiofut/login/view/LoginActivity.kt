package com.brizola.torneiofut.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.brizola.torneiofut.databinding.ActivityLoginBinding
import com.brizola.torneiofut.home.view.HomeActivity
import com.brizola.torneiofut.login.presentation.LoginViewModel
import com.brizola.torneiofut.login.presentation.ViewState

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
                is ViewState.ShowError -> showError()
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
        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
    }

    private fun showError() {
        Toast.makeText(this, "login incompleto", Toast.LENGTH_LONG).show()
    }
}