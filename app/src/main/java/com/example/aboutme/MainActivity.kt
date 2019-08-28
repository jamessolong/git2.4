package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.MyName
import com.example.aboutme.R
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var myName:MyName = MyName("Nattawat Meeleur")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        binding.apply{
            doneButton.setOnClickListener{
                addNickname(it)
            }
            nicknameText.setOnClickListener{
                updateNickName(it)
            }
        }
        binding.myName =  myName

    }

    private fun updateNickName(view: View){
        //val editText = binding.nicknameEdit
        //val nicknameTextView = binding.nicknameText
        //nicknameTextView.text = editText.text
        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE

            //val doneButton = binding.doneButton
            doneButton.visibility = View.VISIBLE

            nicknameEdit.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(nicknameEdit,0)
        }

    }
    private fun addNickname(view: View){

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE

            //val doneButton = binding.doneButton
            doneButton.visibility = View.GONE
            invalidateAll()
//hide the keyboard
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
        }


    }
}
