package com.dog.samurai.sencordetector

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dog.samurai.sencordetector.MainActivity.Companion.ENVIRONMENT_SENSOR
import com.dog.samurai.sencordetector.MainActivity.Companion.MOTION_SENSOR
import com.dog.samurai.sencordetector.MainActivity.Companion.POSITION_SENSOR

class SensorAdapter(private val context: Context,
                    private val sensorTypeList: List<Int>,
                    private val sensorNameList: List<String>,
                    private val sensorNameJP: List<String>,
                    private val enabledList: List<String>
) : RecyclerView.Adapter<SensorAdapter.CardHolder>() {

    var cardListener: CardListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cencor_card_item, parent, false)

        return CardHolder(view).apply {
            view.setOnClickListener { cardListener?.onClick(sensorTypeId, sensorNameText.text.toString(), sensorCategory) }
        }
    }

    override fun getItemCount(): Int {
        return sensorNameList.size
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.sensorNameText.text = sensorNameList[position]
        holder.sensorNameJP.text = sensorNameJP[position]
        holder.sensorTypeId = sensorTypeList[position]
        when (sensorTypeList[position]) {
//            2, 8, 9, 10, 17, 19, 23 -> {
            5, 6, 7, 12, 13, 21, 31 -> {
                holder.sensorTypeImage.setImageResource(R.drawable.ic_leaf)
                holder.sensorTypeImage.setColorFilter(Color.parseColor("#ff669900"))
                holder.sensorCategory = ENVIRONMENT_SENSOR
//                 5, 6, 7, 12, 13
            }
//            3, 4, 12, 13, 15, 16, 18 -> {
            2, 3, 8, 14, 15, 20, 28 -> {
//                15, 20, 2, 14, 3, 8
                holder.sensorTypeImage.setImageResource(R.drawable.ic_tablet_alt)
                holder.sensorTypeImage.setColorFilter(Color.BLUE)
                holder.sensorCategory = POSITION_SENSOR
            }
//            0, 1, 5, 6, 7, 11, 14, 20, 21, 22 -> {
            1, 4, 9, 10, 11, 16, 17, 19, 18, 30, 35 -> {
//                 1, 35, 9, 4, 16, 10, 11, 17, 19, 18
                holder.sensorTypeImage.setImageResource(R.drawable.ic_child)
                holder.sensorTypeImage.setColorFilter(Color.parseColor("#C07A00"))
                holder.sensorCategory = MOTION_SENSOR
            }

        }
        holder.sensorTypeImage
        if (!enabledList.contains(sensorNameList[position])) {
            holder.sensorNameText.setTextColor(Color.LTGRAY)
            holder.sensorActiveImage.setImageResource(R.drawable.ic_frown)
            holder.container.setCardBackgroundColor(Color.parseColor("#E6E6E6"))
        } else {
            holder.sensorNameText.setTextColor(Color.parseColor("#80323232"))
            holder.sensorActiveImage.setImageResource(R.drawable.ic_thumbs_up)
            holder.container.setCardBackgroundColor(Color.WHITE)
        }
    }

    class CardHolder(view: View) : RecyclerView.ViewHolder(view) {
        var sensorNameText: TextView = view.findViewById(R.id.cardTextEn)
        var sensorNameJP: TextView = view.findViewById(R.id.cardTextJp)
        var sensorActiveImage: ImageView = view.findViewById(R.id.cardActiveImage)
        var sensorTypeImage: ImageView = view.findViewById(R.id.cardTypeImage)
        var container: CardView = view.findViewById(R.id.cardContainer)
        var sensorTypeId: Int = -1
        var sensorCategory: Int = -1
    }

    interface CardListener {
        fun onClick(sensorType: Int, sensorName: String, sensorCategory: Int)
    }

}