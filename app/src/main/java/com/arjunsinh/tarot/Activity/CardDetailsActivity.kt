package com.arjunsinh.tarot.Activity

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.arjunsinh.tarot.Activity.CardListActivity
import com.arjunsinh.tarot.R
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel
import com.arjunsinh.tarot.Utils.Constant
import com.arjunsinh.tarot.databinding.ActivityCardDetailsBinding
import com.google.gson.Gson

class CardDetailsActivity : AppCompatActivity() {

    lateinit var binding : ActivityCardDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCardDetailsBinding.inflate(layoutInflater)
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

        if (intent!=null){
            val card_details =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    intent.getParcelableExtra("card_details", CardModel::class.java)
                } else {
                    intent.getParcelableExtra("card_details") as? CardModel
                }

            Constant.log("card_details", Gson().toJson(card_details))
            binding.txtCardName.text = card_details!!.card_name

//            binding.headerLayout.txtTitle.text = card_details.card_name

            binding.txtArcana.text = card_details.arcana
            binding.txtSuit.text = card_details.suit
            binding.txtRank.text = card_details.rank
            binding.txtElement.text = card_details.element
            binding.txtNumber.text = card_details.number.toString()

            binding.txtSuitMeaning.text = "➤ "+card_details.suit_meaning
            binding.txtNumberOrRankMeaning.text = "➤ "+card_details.number_or_rank_meaning

            binding.txtCoreUpright.text = "➤ "+card_details.core_upright
            binding.txtCoreReversed.text = "➤ "+card_details.core_reversed

            binding.txtKeywordsUpright.text = "➤ "+card_details.keywords_upright
            binding.txtKeywordsReversed.text = "➤ "+card_details.keywords_reversed

            binding.txtLoveUpright.text = "➤ "+card_details.love_upright
            binding.txtLoveReversed.text = "➤ "+card_details.love_reversed

            binding.txtCareerUpright.text = "➤ "+card_details.career_upright
            binding.txtCareerReversed.text = "➤ "+card_details.career_reversed

            binding.txtSpiritualUpright.text = "➤ "+card_details.spiritual_upright
            binding.txtSpiritualReversed.text = "➤ "+card_details.spiritual_reversed

            binding.txtSummaryUpright.text = "➤ "+card_details.summary_upright
            binding.txtSummaryReversed.text = "➤ "+card_details.summary_reversed

            val drawableId = Constant.cardImages[card_details.image]
            if (drawableId != null) {
                binding.imgCard.setImageResource(drawableId)
            }
        }
    }

    private fun setClick() {

    }

    fun getCardDetails(){

    }
}