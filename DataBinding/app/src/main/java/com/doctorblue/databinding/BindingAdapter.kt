package com.doctorblue.databinding

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

/*
@BindingAdapter("app:age")
fun checkAge(view: View, age: Int) {
    val txt = view as TextView
    when {
        age < 18 ->{
            txt.text=("You are too young")
        }
        age>=18 -> {
            txt.text=("Eligible")
        }
        else->{
            txt.text=("Empty")
        }
    }
}*/
@BindingAdapter(value = ["app:age", "app:max"], requireAll = true)
fun checkAge(view: View, age: Int, max: Int) {
    val txt = view as TextView
    when {
        age < 18 -> {
            txt.text = ("You are too young")
        }
        (age >= 18) and (age <= max) -> {
            txt.text = ("Eligible")
        }
        age > max -> {
            txt.text = ("You are too old")
        }
        else -> {
            txt.text = ("Empty")
        }
    }
}