package com.dog.samurai.sensordetector

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.dog.samurai.sensordetector.constants.AppConstant.Companion.ENVIRONMENT_SENSOR
import com.dog.samurai.sensordetector.constants.AppConstant.Companion.MOTION_SENSOR
import com.dog.samurai.sensordetector.constants.AppConstant.Companion.POSITION_SENSOR

class SensorAdapter(private val context: Context,
                    private val sensorTypeList: List<Int>,
                    private val sensorNameList: List<String>,
                    private val sensorNameJP: List<String>,
                    private val enabledList: List<String>
) : RecyclerView.Adapter<SensorAdapter.CardHolder>() {

    var cardListener: CardListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.sensor_card_item, parent, false)

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
            5, 6, 7, 12, 13, 21, 31 -> {
                holder.sensorTypeImage.setImageResource(R.drawable.ic_environment)
                holder.sensorTypeIconBackgroung.background = ResourcesCompat.getDrawable(context.resources, R.drawable.shape_circle_light, null)
                holder.sensorCategory = ENVIRONMENT_SENSOR
            }
            2, 3, 8, 14, 15, 20, 28 -> {
                holder.sensorTypeImage.setImageResource(R.drawable.ic_position)
                holder.sensorTypeIconBackgroung.background = ResourcesCompat.getDrawable(context.resources, R.drawable.shape_circle_dark, null)
                holder.sensorCategory = POSITION_SENSOR
            }
            1, 4, 9, 10, 11, 16, 17, 19, 18, 30, 35 -> {
                holder.sensorTypeImage.setImageResource(R.drawable.ic_motion)
                holder.sensorTypeIconBackgroung.background = ResourcesCompat.getDrawable(context.resources, R.drawable.shape_circle_normal, null)
                holder.sensorCategory = MOTION_SENSOR
            }

        }
        holder.sensorTypeImage
        if (!enabledList.contains(sensorNameList[position])) {
            holder.sensorNameText.setTextColor(Color.LTGRAY)
            holder.container.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorMask))
        } else {
            holder.sensorNameText.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
            holder.container.setCardBackgroundColor(Color.WHITE)
        }
    }

    class CardHolder(view: View) : RecyclerView.ViewHolder(view) {
        var sensorNameText: TextView = view.findViewById(R.id.english_name)
        var sensorNameJP: TextView = view.findViewById(R.id.japanese_name)
        var sensorTypeImage: ImageView = view.findViewById(R.id.type_icon)
        var sensorTypeIconBackgroung: FrameLayout = view.findViewById(R.id.type_icon_background)
        var container: CardView = view.findViewById(R.id.cardContainer)
        var sensorTypeId: Int = -1
        var sensorCategory: Int = -1
    }

    interface CardListener {
        fun onClick(sensorType: Int, sensorName: String, sensorCategory: Int)
    }

}