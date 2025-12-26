package com.arjunsinh.tarot

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.arjunsinh.tarot.Activity.CardListActivity
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel
import com.arjunsinh.tarot.RoomDatabase.ViewModel
import com.arjunsinh.tarot.Utils.Constant
import com.arjunsinh.tarot.databinding.ActivityMainBinding
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
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

        sharedPreferences = getSharedPreferences("TarotData", MODE_PRIVATE)
        if (sharedPreferences!!.getString("DataLoaded", "No").equals("No")){
            setupData()
        }

        checkUpdateAvailble()
    }

    private fun setupData() {

        var se = sharedPreferences!!.edit()
        se.putString("DataLoaded","Yes")
        se.apply()
        se.commit()

        var json = assets.open("data.json").bufferedReader().use { it.readText() }
        var list: List<CardModel> = Gson().fromJson(json, object : TypeToken<List<CardModel>>() {}.type)
        Constant.saveData(viewModel, list)
    }

    private fun setClick() {

        binding.btnAll.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.All)
            startActivity(intent)
        }

        binding.btnMajorArcana.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.MajorArcana)
            startActivity(intent)
        }

        binding.btnMinorArcana.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.MinorArcana)
            startActivity(intent)
        }

        binding.btnWands.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Wands)
            startActivity(intent)
        }

        binding.btnSwords.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Swords)
            startActivity(intent)
        }

        binding.btnPentacles.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Pentacles)
            startActivity(intent)
        }

        binding.btnCups.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Cups)
            startActivity(intent)
        }

        binding.btnPages.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Pages)
            startActivity(intent)
        }

        binding.btnQueens.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Queens)
            startActivity(intent)
        }

        binding.btnKnights.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Knights)
            startActivity(intent)
        }

        binding.btnKings.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Kings)
            startActivity(intent)
        }

        binding.btnNumber1.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Number1)
            startActivity(intent)
        }

        binding.btnNumber2.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Number2)
            startActivity(intent)
        }

        binding.btnNumber3.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Number3)
            startActivity(intent)
        }

        binding.btnNumber4.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Number4)
            startActivity(intent)
        }

        binding.btnNumber5.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Number5)
            startActivity(intent)
        }

        binding.btnNumber6.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Number6)
            startActivity(intent)
        }

        binding.btnNumber7.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Number7)
            startActivity(intent)
        }

        binding.btnNumber8.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Number8)
            startActivity(intent)
        }

        binding.btnNumber9.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Number9)
            startActivity(intent)
        }

        binding.btnNumber10.setOnClickListener {
            var intent = Intent(this@MainActivity, CardListActivity::class.java)
            intent.putExtra("CardType", Constant.keyWords.Number10)
            startActivity(intent)
        }
    }

    fun checkUpdateAvailble() {
        val appUpdateManager = AppUpdateManagerFactory.create(this)
        val appUpdateInfoTask = appUpdateManager.appUpdateInfo
        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo: AppUpdateInfo ->
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
                appUpdateManager.startUpdateFlowForResult(appUpdateInfo, activityResultLauncher, AppUpdateOptions.newBuilder(AppUpdateType.FLEXIBLE).build())
            }
        }
    }

    var activityResultLauncher: ActivityResultLauncher<IntentSenderRequest> =
        registerForActivityResult(
            StartIntentSenderForResult(),
            object : ActivityResultCallback<ActivityResult> {
                override fun onActivityResult(result: ActivityResult) {
                    // handle callback
                    if (result.resultCode != RESULT_OK) {
                        Constant.log("ActivityResultCallback", "Update flow failed! Result code: " + result.resultCode)
                        // If the update is canceled or fails,
                        // you can request to start the update again.
                    }
                }
            })
}