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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.dogshoke.a0612project.databinding.ActivityMainBinding
import ru.dogshoke.a0612project.databinding.SecondActivityBinding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[SecondViewModel::class.java]
        val binding: SecondActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.second_activity)
        setContentView(binding.root)
        viewModel.initBase(this, binding)
        binding.viewModel = viewModel
        val adapter2 = MyAchievmentAdapter(makeAchivment())
        val rv = findViewById<RecyclerView>(R.id.RV)
        rv.adapter = adapter2

        val button = binding.button
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val status = resources.getStringArray(R.array.status)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, status)
        binding.spinner.adapter = adapter

        binding.spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var selectedItem = status[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        })
    }

    fun makeAchivment() : Array<Achievment?>{
        val arr = arrayOfNulls<Achievment>(9)
        val achievmentArr = arrayOf("Достижение 1", "Достижение 2", "Достижение 3", "Достижение 4", "Достижение 5", "Достижение 6", "Достижение 7", "Достижение 8","Достижение 9")
        val dateArr = arrayOf("1", "2", "3", "4", "5", "6", "7", "8","9")
        for (i in arr.indices){
            val achievment = Achievment()
            achievment.name = achievmentArr[i]
            achievment.date = dateArr[i]
            arr[i] = achievment
        }

        return arr
    }
}