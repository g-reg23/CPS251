package edu.wccnet.sgm114.recycleviewwithintents

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import edu.wccnet.sgm114.recycleviewwithintents.databinding.ActivitySecondBinding
import edu.wccnet.sgm114.recycleviewwithintents.Data

class SecondActivity : AppCompatActivity() {
    private val data: Data get() {
        return Data()
    }
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras?:return
        binding.tv1.text = data.titles[extras.getInt("num3")]
        binding.tv2.text = data.details[extras.getInt("num1")]
        binding.finalIV.setImageResource(data.images[extras.getInt("num2")])
    }

}