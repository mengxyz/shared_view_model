package com.mengxyz.example.sharedviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.input

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            add(R.id.fragment_1, Fragment1())
            add(R.id.fragment_2, Fragment2())
        }

        val model = ViewModelProvider(this).get(SharedViewModel::class.java)

        input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                model.submitString(p0?.toString() ?: return)
            }
        })
    }
}