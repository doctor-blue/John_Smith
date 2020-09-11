package com.doctorblue.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.doctorblue.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by lazy {
        ViewModelProvider(this)[UserViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        /*
          //Part 1
          binding.sum = 0

          binding.btnCalc.setOnClickListener {
              val numA = binding.edtNumA.text.toString().toInt()
              val numB = binding.edtNumB.text.toString().toInt()

              binding.sum = numA + numB

          }*/

        /* Part 2
         binding.lifecycleOwner = this

          binding.viewModel = viewModel*/

        /* Part 3
         val adapter = UserAdapter()
         adapter.users = createData()

         binding.rvMain.setHasFixedSize(true)
         binding.rvMain.layoutManager = LinearLayoutManager(this)
         binding.rvMain.adapter = adapter*/


        binding.btnSubmit.setOnClickListener {
            val age = binding.edtAge.text.toString().toInt()
            binding.age = age
        }


    }

    private fun createData(): MutableList<User> {
        val users = mutableListOf<User>()

        for (i in 1..20) {
            val user = User("John__$i", i)
            users.add(user)
        }
        users.shuffle()
        return users
    }


}