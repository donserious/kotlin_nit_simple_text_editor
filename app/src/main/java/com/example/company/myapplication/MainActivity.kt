package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAll ()
        stats_view.text = "0"
        // Write your code here


    }

    var text: String = "^"

    private fun setAll () {

        save_button.setOnClickListener{v : View ->
            text = editText.text.toString()
            unsaved_changes_view.text = "All changes saved"
        }


        clear_button.setOnClickListener { v: View ->

            editText.setText("")
            stats_view.text = "0"
        }

        load_button.setOnClickListener{v : View ->
            editText.setText(text)
        }





        editText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString() != text )  unsaved_changes_view.text = "Unsaved changes" else unsaved_changes_view.text = "All changes saved"
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() == "") stats_view.text = "0"
                if ((p0.toString() != "") && (!p0!!.contains(" "))) stats_view.text = "1"

                var stroka: String = p0.toString().replace("[^А-Яа-яA-Za-z0-9_ ]".toRegex(), " ").trim()
                var str: String = ""
                if (stroka.contains(" ")) {
                    var arrayWord: MutableList<String> = stroka.split("[! -]".toRegex()).toMutableList()
                    var arrayWordNew: MutableList<String> = mutableListOf()
                    for (i in 0 until arrayWord.size){
                        if (arrayWord[i] != "") arrayWordNew.add(arrayWord[i])
                    }
                    stats_view.text = arrayWordNew.size.toString()
                    for (i in arrayWordNew.indices) {
                        str += "$i"+"_"+arrayWordNew[i]+"_"
                    }
                    var a: Toast = Toast.makeText(applicationContext, "$str", Toast.LENGTH_LONG)
                    a.show()
                }



            }
        })
    }


}
