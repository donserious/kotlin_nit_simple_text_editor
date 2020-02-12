package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAll ()
        // Write your code here


    }

    private fun setAll () {
        editText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var stroka: String = p0.toString().replace("[^A-Za-z0-9_ ]".toRegex(), " ")
                stroka = stroka.trim()
                if (stroka.contains(" ")) {
                    var arrayWord: List<String> = stroka.split(" ")
                    stats_view.text = arrayWord.size.toString()
                }

//                val toast = Toast.makeText(applicationContext,arrayWord.size,Toast.LENGTH_SHORT)
//                toast.show()

            }

        })
    }


}
