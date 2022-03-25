package edu.wccnet.sgm114.lifecycleawareness.ui.main

import androidx.annotation.Keep
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object Singleton {
        private var text: MutableLiveData<String> = MutableLiveData("")
        fun getText(): MutableLiveData<String> {
            return text
        }
        fun setText(t: String) {
            text.value = text.value + "\n" + t

        }
    }
}