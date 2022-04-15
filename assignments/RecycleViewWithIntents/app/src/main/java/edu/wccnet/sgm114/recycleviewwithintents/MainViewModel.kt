package edu.wccnet.sgm114.recycleviewwithintents

import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    companion object Instance {
        private var randList: Array<IntArray> = arrayOf(
            intArrayOf(getRandomNum(), getRandomNum(), getRandomNum()),
            intArrayOf(getRandomNum(), getRandomNum(), getRandomNum()),
            intArrayOf(getRandomNum(), getRandomNum(), getRandomNum()),
            intArrayOf(getRandomNum(), getRandomNum(), getRandomNum()),
            intArrayOf(getRandomNum(), getRandomNum(), getRandomNum()),
            intArrayOf(getRandomNum(), getRandomNum(), getRandomNum()),
            intArrayOf(getRandomNum(), getRandomNum(), getRandomNum()),
            intArrayOf(getRandomNum(), getRandomNum(), getRandomNum()),
        )
        fun getRandList(): Array<IntArray> {
            return randList
        }

        private fun getRandomNum(): Int {
            return (0..7).random()
        }
    }
}