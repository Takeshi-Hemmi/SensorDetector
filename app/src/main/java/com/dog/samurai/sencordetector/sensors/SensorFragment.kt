package com.dog.samurai.sencordetector.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dog.samurai.sencordetector.R
import kotlinx.android.synthetic.main.fragment_light_sensor.*

class SensorFragment : Fragment(), SensorEventListener {

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(event: SensorEvent) {
        parameterText.text = event.values[0].toString()
    }

    private var name: String? = null
    private var mParam2: Int? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (arguments != null) {
            name = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getInt(ARG_PARAM2)
        }
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_light_sensor, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        when (name) {
            "AMBIENT_TEMPERATURE" -> {
                sensorDescription.text = "周囲の温度を表示します。"
                paramNameText.text = "気温"
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
            }
            "LIGHT" -> {
                sensorDescription.text = "照度を数値化します。"
                paramNameText.text = "照度"
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
            }
            "PRESSURE" -> {
                sensorDescription.text = "周囲の空気圧を表示します。"
                paramNameText.text = "気圧"
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)
            }
            "RELATIVE_HUMIDITY" -> {
                sensorDescription.text = "周囲の相対湿度を表示します。"
                paramNameText.text = "湿度"
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY)
            }
            "TEMPERATURE" -> {
                sensorDescription.text = "端末の温度を表示します。"
                paramNameText.text = "温度"
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE)
            }
            else -> {
                activity.supportFragmentManager.popBackStack()
            }
        }

        sensorName.text = name


    }

    lateinit var sensorManager: SensorManager
    lateinit var sensor: Sensor

    companion object {
        private const val ARG_PARAM1 = "sensorName"
        private const val ARG_PARAM2 = "sensorType"

        fun newInstance(param1: String, param2: Int): SensorFragment {
            val fragment = SensorFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putInt(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}// Required empty public constructor
