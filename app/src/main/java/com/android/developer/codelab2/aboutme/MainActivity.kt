package com.android.developer.codelab2.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.android.developer.codelab2.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

     lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
        // setContentView(R.layout.activity_main)
        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }
        setContentView(binding.root)
    }

    // view é uma instância do botão DONE na UI activity_main
    fun addNickName(view : View) {
        val editText = binding.nicknameEdit
        val nicknameTextView = binding.nicknameText

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE // Desapareçe com a caixa de texto
        view.visibility = View.GONE // Desaparece com o botão
        nicknameTextView.visibility = View.VISIBLE // Torna visivel a label com o nome fornecida.

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }

    fun updateNickname(view : View) {
        val editText = binding.nicknameEdit
        val doneButton = binding.doneButton
        val nicknameTextView = binding.nameText

        editText.visibility = View.VISIBLE
        nicknameTextView.visibility = View.GONE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}