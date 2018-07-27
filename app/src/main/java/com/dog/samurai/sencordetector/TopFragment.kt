package com.dog.samurai.sencordetector

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dog.samurai.sencordetector.sensors.EnvironmentSensorFragment
import com.dog.samurai.sencordetector.sensors.MotionSensorFragment
import com.dog.samurai.sencordetector.sensors.PositionSensorFragment

class TopFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_top, container, false)
    }
    private var fragment : Fragment? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).apply {
            findViewById<RecyclerView>(R.id.sensor_recycler).apply {
                setHasFixedSize(true)
                adapter = SensorAdapter(this.context, MainActivity.sensorTypeList, MainActivity.sensorNameList, MainActivity.sensorNameListJP, enabledList).apply {
                    cardListener = object : SensorAdapter.CardListener {
                        override fun onClick(sensorType: Int, sensorName: String, sensorCategory: Int) {
                            if (enabledList.contains(sensorName) && sensorCategory == MainActivity.ENVIRONMENT_SENSOR) {
                                 fragment = EnvironmentSensorFragment.newInstance(sensorName, sensorType)
                            } else if (enabledList.contains(sensorName) && sensorCategory == MainActivity.MOTION_SENSOR) {
                                 fragment = MotionSensorFragment.newInstance(sensorName, sensorType)
                            } else if (enabledList.contains(sensorName) && sensorCategory == MainActivity.POSITION_SENSOR) {
                                 fragment = PositionSensorFragment.newInstance(sensorName, sensorType)
                            }

                            renderFragment(fragment)
                        }
                    }
                }
                layoutManager = LinearLayoutManager(this.context)
            }
        }
    }
}