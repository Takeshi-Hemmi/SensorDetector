package com.dog.samurai.sensordetector

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dog.samurai.sensordetector.constants.AppConstant.Companion.ENVIRONMENT_SENSOR
import com.dog.samurai.sensordetector.constants.AppConstant.Companion.MOTION_SENSOR
import com.dog.samurai.sensordetector.constants.AppConstant.Companion.POSITION_SENSOR
import com.dog.samurai.sensordetector.constants.AppConstant.Companion.sensorNameList
import com.dog.samurai.sensordetector.constants.AppConstant.Companion.sensorNameListJP
import com.dog.samurai.sensordetector.constants.AppConstant.Companion.sensorTypeList
import com.dog.samurai.sensordetector.sensors.EnvironmentSensorFragment
import com.dog.samurai.sensordetector.sensors.MotionSensorFragment
import com.dog.samurai.sensordetector.sensors.PositionSensorFragment

class TopFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    private var fragment: Fragment? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).apply {
            findViewById<RecyclerView>(R.id.sensor_recycler).apply {
                setHasFixedSize(true)
                adapter = SensorAdapter(this.context, sensorTypeList, sensorNameList, sensorNameListJP, enabledList).apply {
                    cardListener = object : SensorAdapter.CardListener {
                        override fun onClick(sensorType: Int, sensorName: String, sensorCategory: Int) {
                            if (enabledList.contains(sensorName) && sensorCategory == ENVIRONMENT_SENSOR) {
                                fragment = EnvironmentSensorFragment.newInstance(sensorName, sensorType)
                                renderFragment(fragment)
                            } else if (enabledList.contains(sensorName) && sensorCategory == MOTION_SENSOR) {
                                fragment = MotionSensorFragment.newInstance(sensorName, sensorType)
                                renderFragment(fragment)
                            } else if (enabledList.contains(sensorName) && sensorCategory == POSITION_SENSOR) {
                                fragment = PositionSensorFragment.newInstance(sensorName, sensorType)
                                renderFragment(fragment)
                            }
                        }
                    }
                }
                layoutManager = LinearLayoutManager(this.context)
            }
        }
    }
}