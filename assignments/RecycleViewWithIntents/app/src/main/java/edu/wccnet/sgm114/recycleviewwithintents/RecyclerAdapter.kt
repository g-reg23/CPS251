package edu.wccnet.sgm114.recycleviewwithintents

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.String
import kotlin.Array
import kotlin.Int
import kotlin.IntArray
import kotlin.arrayOf
import kotlin.intArrayOf
import edu.wccnet.sgm114.recycleviewwithintents.Data


class RecyclerAdapter: RecyclerView.Adapter<edu.wccnet.sgm114.recycleviewwithintents.RecyclerAdapter.ViewHolder>()  {
    private val list: Array<IntArray> = MainViewModel.getRandList()
    private val main:MainActivity = MainActivity()
    private val data: Data get() {
        return Data()
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemDetail.text = data.details[list[position][0]]
        holder.itemImage.setImageResource(data.images[list[position][1]])
        holder.itemTitle.text = data.titles[list[position][2]]
        holder.itemView.setOnClickListener {
            var i = Intent(it.context, SecondActivity::class.java)
            var bundle: Bundle = Bundle()
            i.putExtra("num1", list[position][0])
            i.putExtra("num2", list[position][1])
            i.putExtra("num3", list[position][2])
            it.context.startActivity(i)
        }

    }

    override fun getItemCount(): Int {
        return data.titles.size
    }
}