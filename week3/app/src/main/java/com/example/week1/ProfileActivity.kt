package com.example.week1

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.LayoutInflaterCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.week1.databinding.ActivityProfileBinding
import com.google.android.material.dialog.MaterialDialogs



class ProfileActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityProfileBinding
    private lateinit var  viewModel: ProfileViewModel
    private lateinit var  viewModelFactory: ProfileViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        viewModelFactory = ProfileViewModelFactory("duong","duong@gmail.com","123")
        viewModel = ViewModelProvider(this,viewModelFactory).get(ProfileViewModel::class.java)
        binding.user = viewModel.user.value
        viewModel.user.observe(this, {
            binding.FullNameDescription.text = it.name
            binding.EmailDescription.text = it.email
            binding.PhoneDescription.text = it.phoneNumber
        })




//        val fullNameDescription = findViewById<TextView>(R.id.FullNameDescription)
//        val emailDescription = findViewById<TextView>(R.id.EmailDescription)
//        val phoneDescription = findViewById<TextView>(R.id.PhoneDescription)
        binding.apply {
            editTextFullName.setOnClickListener{
                val dialogName = AlertDialog.Builder(this@ProfileActivity)
                val inflater = layoutInflater
                val dialogLayout =  inflater.inflate(R.layout.dialog_full_name,null)
                val editText = dialogLayout.findViewById<EditText>(R.id.editDialogFullName)
                with(dialogName){
                    setTitle("Nhap Ho ten day du")
                    setPositiveButton("OK"){dialog, which ->

                        val userName = editText.text.toString().trim()
                        viewModel.setAccountUserName(userName)

                }
               setView(dialogLayout)
                }
            dialogName.show()

            }

            editTextEmail.setOnClickListener {
                val dialogEmail = AlertDialog.Builder(this@ProfileActivity)
                val inflater = layoutInflater
                val dialogLayout = inflater.inflate(R.layout.dialog_email,null)
                val editText = dialogLayout.findViewById<EditText>(R.id.editDialogEmail)
                with(dialogEmail){
                    setTitle("Nhap EMAIL")
                    setPositiveButton("OK"){dialog, which ->

                        val userEmail = editText.text.toString().trim()
                        viewModel.setAccountUserEmail(userEmail)
                    }
                    setView(dialogLayout)
                }
                dialogEmail.show()
            }
            editTextPhoneNo.setOnClickListener {
                val dialogPhone = AlertDialog.Builder(this@ProfileActivity)
                val inflater = layoutInflater
                val dialogLayout = inflater.inflate(R.layout.dialog_phone,null)
                val editText =dialogLayout.findViewById<EditText>(R.id.editDialogPhone)
                with(dialogPhone){
                    setTitle("Nhap PHONE")
                    setPositiveButton("OK"){digalog, with ->
                        val userPhoneNumber = editText.text.toString().trim()
                        viewModel.setAccountUserPhone(userPhoneNumber)
                    }
                    setView(dialogLayout)
                }
                dialogPhone.show()
            }

        }



//        val editTextFullName = findViewById<ImageButton>(R.id.editTextFullName)
//        val editTextEmail = findViewById<ImageButton>(R.id.editTextEmail)
//        val editTextPhone = findViewById<ImageButton>(R.id.editTextPhoneNo)

       // editTextFullName.setOnClickListener {
        //    val dialogName = AlertDialog.Builder(this)

            //dialogName.apply{
           //     setTitle("Nhap Ho ten day du")
            //    EditText fn =
            //}
           // dialogName.setView(R.layout.dialog_full_name)
           // dialogName.setPositiveButton("OK",DialogInterface.OnClickListener({dialog, id -> }))
          // var editTextFullName = findViewById<EditText>(R.id.editDialogFullName)

           // dialogName.show()
       // }

//        editTextFullName.setOnClickListener {
//            val dialogName = AlertDialog.Builder(this)
//            val inflater = layoutInflater
//            val dialogLayout = inflater.inflate(R.layout.dialog_full_name,null)
//            val editText = dialogLayout.findViewById<EditText>(R.id.editDialogFullName)
//
//            with(dialogName){
//                setTitle("Nhap Ho ten day du")
//                setPositiveButton("OK"){dialog, which ->
//                    fullNameDescription.text = editText.text.toString()
//                }
//               setView(dialogLayout)
//            }
//            dialogName.show()
//        }





//        editTextEmail.setOnClickListener {
//            val dialogEmail = AlertDialog.Builder(this)
//            val inflater = layoutInflater
//            val dialogLayout = inflater.inflate(R.layout.dialog_email,null)
//            val editText = dialogLayout.findViewById<EditText>(R.id.editDialogEmail)
//
//            with(dialogEmail){
//                setTitle("Nhap EMAIL")
//                setPositiveButton("OK"){dialog, which ->
//                    emailDescription.text = editText.text.toString()
//                }
//                setView(dialogLayout)
//            }
//            dialogEmail.show()
//        }
//        editTextPhone.setOnClickListener {
//            val dialogName = AlertDialog.Builder(this)
//            val inflater = layoutInflater
//            val dialogLayout = inflater.inflate(R.layout.dialog_phone,null)
//            val editText = dialogLayout.findViewById<EditText>(R.id.editDialogPhone)
//
//            with(dialogName){
//                setTitle("Nhap So dien thoai")
//                setPositiveButton("OK"){dialog, which ->
//                    phoneDescription.text = editText.text.toString()
//                }
//                setView(dialogLayout)
//            }
//            dialogName.show()
//        }

    }
}


