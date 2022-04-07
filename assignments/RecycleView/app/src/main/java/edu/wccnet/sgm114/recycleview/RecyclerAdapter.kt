package edu.wccnet.sgm114.recycleview

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import android.util.Log

class RecyclerAdapter:RecyclerView.Adapter<edu.wccnet.sgm114.recycleview.RecyclerAdapter.ViewHolder>() {
    private val list: Array<IntArray> = MainViewModel.getRandList()
    private val titles = arrayOf("Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5",
        "Chapter 6", "Chapter 7", "Chapter 8")
    private val details = arrayOf("Item 1 details", "Item 2 details", "Item 3 details", "Item 4 details",
        "Item 5 details", "Item 6 details", "Item 7 details", "Item 8 details")
    private val images = intArrayOf(R.drawable.android_image_1, R.drawable.android_image_2,R.drawable.android_image_3,
        R.drawable.android_image_4,R.drawable.android_image_5,R.drawable.android_image_6,R.drawable.android_image_7,
        R.drawable.android_image_8)
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)
            itemView.setOnClickListener {v: View ->
                var position: Int = adapterPosition
                Snackbar.make(v, "Click detected on item $position", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemDetail.text = details[list[position][0]]
        holder.itemImage.setImageResource(images[list[position][1]])
        holder.itemTitle.text = titles[list[position][2]]
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}