package com.example.datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userManager = UserManager(this)

        CoroutineScope(Dispatchers.Main).launch {

            launch {
                userManager.userNameFlow.collect {
                    txt_user_name.text = it
                }
            }
           launch {
               userManager.passwordFlow.collect {
                   txt_password.text = it
               }
           }
        }


        btn_save.setOnClickListener {
            val userName = edt_user_name.text.toString()
            val password = edt_password.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                userManager.storeUser(userName, password)
            }
        }
    }
}