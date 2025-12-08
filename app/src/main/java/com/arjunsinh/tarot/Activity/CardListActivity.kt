package com.arjunsinh.tarot.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.arjunsinh.tarot.R
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel
import com.arjunsinh.tarot.RoomDatabase.ViewModel
import com.arjunsinh.tarot.databinding.ActivityCardListBinding

class CardListActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModel
    lateinit var binding: ActivityCardListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCardListBinding.inflate(layoutInflater)
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

        viewModel.getAllCard().observe(this@CardListActivity) { it: List<CardModel>? ->


            binding.recycler.layoutManager = GridLayoutManager(this,1)
            binding.recycler.adapter
        }
    }

    private fun setClick() {

    }
}