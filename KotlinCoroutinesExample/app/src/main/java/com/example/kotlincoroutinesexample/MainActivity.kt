package com.example.kotlincoroutinesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlincoroutinesexample.coroutinecontext.TestDispatchers
import com.example.kotlincoroutinesexample.coroutinecontext.TestWithContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TestWithContext.testMySecondWithContextFunc()
    }
}