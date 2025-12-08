package com.arjunsinh.tarot

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.arjunsinh.tarot.Activity.CardListActivity
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel
import com.arjunsinh.tarot.RoomDatabase.ViewModel
import com.arjunsinh.tarot.Utils.Constant
import com.arjunsinh.tarot.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inIt()
        setClick()
    }

    private fun inIt() {
        viewModel = ViewModel(application, this)

//        var json = assets.open("data.json").bufferedReader().use { it.readText() }
//        var list: List<CardModel> = Gson().fromJson(json, object : TypeToken<List<CardModel>>() {}.type)
//        Constant.saveData(viewModel, list)
    }

    private fun setClick() {

        binding.btnAll.setOnClickListener {
            startActivity(Intent(this@MainActivity, CardListActivity::class.java))
        }
    }
}