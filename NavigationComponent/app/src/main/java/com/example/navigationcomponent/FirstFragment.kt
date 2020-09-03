package com.example.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val controller = findNavController()

        btn_open_fragment_two.setOnClickListener {
            /* val bundle = bundleOf(
                 "userName" to edt_name.text.toString()
             )*/
            val user = User(edt_name.text.toString(), edt_age.text.toString().toInt())
            /*  val bundle= bundleOf(
                  "user" to user
              )*/
            val address = "Ha Noi"

            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(address, user)

            controller.navigate(action)
        }

        btn_open_fragment_three.setOnClickListener {
            controller.navigate(R.id.thirdFragment)
        }

    }


}