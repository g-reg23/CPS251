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
                binding.instructionTV.text = R.string.app_instructions_ii.toString()
                binding.instructionTV.setTextColor(Color.parseColor("#ff0033"))
                binding.tipTV1.text = ""
                binding.tipTV2.text = ""
                binding.tipTV3.text = ""
            } else {
                binding.instructionTV.text = R.string.app_instructions_iii.toString()
                binding.instructionTV.setTextColor(Color.parseColor("#000000"))
                val tip1 = (binding.numInput.text.toString().toDouble() * .2)
                val tip2 = (binding.numInput.text.toString().toDouble() * .18)
                val tip3 = (binding.numInput.text.toString().toDouble() * .15)
                val tip4 = String.format("%.2f", tip1)
                val tip5 = String.format("%.2f", tip2)
                val tip6 = String.format("%.2f", tip3)
                binding.tipTV1.text = "" + R.string.tipText1 + "$tip4"
                binding.tipTV2.text = "" + R.string.tipText2 + "$tip5"
                binding.tipTV3.text = "" + R.string.tipText3 + "$tip6"
            }
        }
    }
}