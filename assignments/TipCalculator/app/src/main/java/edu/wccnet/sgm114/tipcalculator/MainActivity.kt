package edu.wccnet.sgm114.tipcalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.wccnet.sgm114.tipcalculator.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            if (binding.numInput.text.toString().isEmpty()) {
                binding.instructionTV.text = "PLEASE ENTER A BILL VALUE"
                binding.instructionTV.setTextColor(Color.parseColor("#ff0033"))
                binding.tipTV1.text = ""
                binding.tipTV2.text = ""
                binding.tipTV3.text = ""
            } else {
                binding.instructionTV.text = "The tip amounts are below:"
                binding.instructionTV.setTextColor(Color.parseColor("#000000"))
                val tip1 = (binding.numInput.text.toString().toDouble() * .2)
                val tip2 = (binding.numInput.text.toString().toDouble() * .18)
                val tip3 = (binding.numInput.text.toString().toDouble() * .15)
                val tip4 = String.format("%.2f", tip1)
                val tip5 = String.format("%.2f", tip2)
                val tip6 = String.format("%.2f", tip3)
                val tip7 = "20% TIP = $$tip4"
                val tip8 = "18% TIP = $$tip5"
                val tip9 = "15% TIP = $$tip6"
                binding.tipTV1.text = tip7
                binding.tipTV2.text = tip8
                binding.tipTV3.text = tip9
            }
        }
    }
}
