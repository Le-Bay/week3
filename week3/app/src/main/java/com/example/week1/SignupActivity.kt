package com.example.week1
import android.content.Intent
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.week1.databinding.ActivitySignupBinding
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import java.util.regex.Pattern


class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: SignupViewModel
    private lateinit var viewModelFactory: SignupViewModelFactory
    lateinit var email: String
    lateinit var password: String
    lateinit var username: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_signup)
        viewModelFactory = SignupViewModelFactory("bay","bay@gmail.com","123")
        viewModel= ViewModelProvider(this,viewModelFactory).get(SignupViewModel::class.java)
        binding.apply {

            editTextTextPersonName.setOnClickListener {

                val username = editTextTextPersonName.text.toString().trim()
                viewModel.setAccountUserName(username)
            }
            editTextTextPersonName2.setOnClickListener {
                val email = editTextTextPersonName2.text.toString().trim()
                viewModel.setAccountUserName(email)
            }

            editTextTextPassword.setOnClickListener {
                val password = editTextTextPassword.text.toString().trim()
                viewModel.setAccountUserName(password)

            }
        }
            binding.LoginButton.setOnClickListener {
            if (email.isEmpty()) {
                binding.editTextTextPersonName2.error = "Please enter the email"
            }
            else if ( !isEmailValid(email)) {
                binding.editTextTextPersonName2.error = "Please enter correct format"
            }
            else if (password.isEmpty()) {
                binding.editTextTextPassword.error = "Please enter the password"
            }
            else if (!isPasswordValid(password)) {
                binding.editTextTextPassword.error = "Please enter correct format"
            }
            else {

                Toast.makeText(this, "Login complete", Toast.LENGTH_LONG).show()

            }

        }
        binding.account = viewModel.account.value
        viewModel.account.observe(this, Observer {
            binding.editTextTextPersonName.setText(it.username)
            binding.editTextTextPersonName2.setText(it.email)
            binding.editTextTextPassword.setText(it.password)
        }  )
        binding.tvLogin.setOnClickListener{
            val intent = Intent(this@SignupActivity, SigninActivity::class.java)
            startActivity(intent)
        }
    }
    fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
                "^[a-zA-Z][\\\\w-]+@([\\\\w]+\\\\.[\\\\w]+|[\\\\w]+\\\\.[\\\\w]{2,}\\\\.[\\\\w]{2,})\$"

        ).matcher(email).matches()
    }
    fun isPasswordValid(password: String): Boolean {
        return Pattern.compile(
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!\\-_?&])(?=\\S+$).{8,}"
        ).matcher(password).matches(

        )
    }
}

}