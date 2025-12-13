package com.arjunsinh.tarot.Activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.arjunsinh.tarot.Adapter.RecyclerCardListAdapter
import com.arjunsinh.tarot.R
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel
import com.arjunsinh.tarot.RoomDatabase.ViewModel
import com.arjunsinh.tarot.Utils.Constant
import com.arjunsinh.tarot.databinding.ActivityCardListBinding

class CardListActivity : AppCompatActivity() {

    lateinit var adapter: RecyclerCardListAdapter
    var mainList : List<CardModel> = emptyList()
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

        adapter = RecyclerCardListAdapter(emptyList())
        binding.recycler.layoutManager = GridLayoutManager(this,1)
        binding.recycler.adapter = adapter

        getCardData()
    }

    private fun setClick() {

        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (p0!!.isEmpty()){
                    adapter.updateData(mainList)
                }else{
                    filter(p0.toString().trim())
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }

    private fun filter(searchText: String) {

        var list : MutableList<CardModel> = mutableListOf()

        for (cardModel in mainList){
            if (cardModel.card_name.lowercase().contains(searchText.lowercase().trim())){
                list.add(cardModel)
            }
        }
        adapter.updateData(list)
    }

    private fun getCardData() {

        var arcana = ""
        var suit = ""
        var rank = ""

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.MajorArcana)){
            arcana = "major"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.MinorArcana)){
            arcana = "minor"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Wands)){
            suit = "wands"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Swords)){
            suit = "swords"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Pentacles)){
            suit = "pentacles"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Cups)){
            suit = "cups"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Pages)){
            rank = "page"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Knights)){
            rank = "knight"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Queens)){
            rank = "queen"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Kings)){
            rank = "king"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Number1)){
            rank = "ace"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Number2)){
            rank = "2"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Number3)){
            rank = "3"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Number4)){
            rank = "4"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Number5)){
            rank = "5"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Number6)){
            rank = "6"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Number7)){
            rank = "7"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Number8)){
            rank = "8"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Number9)){
            rank = "9"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.Number10)){
            rank = "10"
        }

        if (intent.getStringExtra("CardType").equals(Constant.keyWords.All)) {
            viewModel.getAllCard().observe(this@CardListActivity) { it: List<CardModel>? ->

                mainList = it!!

                adapter.updateData(mainList)
            }
        }
        if (arcana.isNotEmpty()) {
            viewModel.getCardByArcana(arcana).observe(this@CardListActivity) { it: List<CardModel>? ->

                mainList = it!!

                adapter.updateData(mainList)
            }
        }
        if (suit.isNotEmpty()) {
            viewModel.getCardBySuit(suit).observe(this@CardListActivity) { it: List<CardModel>? ->

                mainList = it!!

                adapter.updateData(mainList)
            }
        }
        if (rank.isNotEmpty()) {
            viewModel.getCardByRank(rank).observe(this@CardListActivity) { it: List<CardModel>? ->

                mainList = it!!

                adapter.updateData(mainList)
            }
        }
    }
}