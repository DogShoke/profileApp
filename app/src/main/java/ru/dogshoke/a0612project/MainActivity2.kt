package ru.dogshoke.a0612project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ru.dogshoke.a0612project.databinding.ActivityMainBinding
import ru.dogshoke.a0612project.databinding.SecondActivityBinding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[SecondViewModel::class.java]
        val binding : SecondActivityBinding = DataBindingUtil.setContentView(this, R.layout.second_activity)
        setContentView(binding.root)
        viewModel.initBase(this,binding)
        binding.viewModel = viewModel

        val button = binding.button
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val status = resources.getStringArray(R.array.status)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, status)
        binding.spinner.adapter = adapter

        binding.spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            var selectedItem = status[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        })
    }
}