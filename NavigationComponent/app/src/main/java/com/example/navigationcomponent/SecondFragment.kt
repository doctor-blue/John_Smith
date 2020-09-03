package com.example.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val controller = findNavController()

        /* val bundle = arguments
         //val userName = bundle?.getString("userName")

         val user = bundle?.getSerializable("user") as User*/

        val args: SecondFragmentArgs by navArgs()
        val user = args.user
        val address = args.address

        txt_name.text = ("$user - $address")

        btn_open_fragment_three.setOnClickListener {
            controller.navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }

}