package com.wccnet.edu.addnamesavedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wccnet.edu.addnamesavedata.ui.main.MainFragment
import com.wccnet.edu.addnamesavedata.databinding.MainActivityBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}