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

class EnvironmentSensorFragment : Fragment(), SensorEventListener {

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        parameterText.text = event.values[0].toString()
    }

    private lateinit var sensorManager: SensorManager
    private lateinit var sensor: Sensor
    private var sensorNameArg: String? = null
    private var sensorTypeArg: Int? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (arguments != null) {
            sensorNameArg = arguments.getString(SENSOR_NAME_ARG)
            sensorTypeArg = arguments.getInt(SENSOR_TYPE_ARG)
        }
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_light_sensor, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorName.text = sensorNameArg
        paramNameText.visibility = View.VISIBLE
        paramNameText.visibility = View.VISIBLE

        when (sensorNameArg) {
            "AMBIENT_TEMPERATURE" -> {
                sensorDescription.text = resources.getString(R.string.environ_ambient_temperate_desc)
                paramNameText.text = resources.getString(R.string.environ_ambient_temperate_title)
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
            }
            "LIGHT" -> {
                sensorDescription.text = resources.getString(R.string.environ_light_desc)
                paramNameText.text = resources.getString(R.string.environ_light_title)
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
            }
            "PRESSURE" -> {
                sensorDescription.text = resources.getString(R.string.environ_pressure_desc)
                paramNameText.text = resources.getString(R.string.environ_pressure_title)
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)
            }
            "RELATIVE_HUMIDITY" -> {
                sensorDescription.text = resources.getString(R.string.environ_relative_humidity_desc)
                paramNameText.text = resources.getString(R.string.environ_relative_humidity_title)
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY)
            }
            "TEMPERATURE" -> {
                sensorDescription.text = resources.getString(R.string.environ_temperate_desc)
                paramNameText.text = resources.getString(R.string.environ_temperate_title)
                @Suppress("DEPRECATION")
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE)
            }
            else -> {
                activity.supportFragmentManager.popBackStack()
            }
        }
    }

    companion object {
        private const val SENSOR_NAME_ARG = "sensorName"
        private const val SENSOR_TYPE_ARG = "sensorType"

        fun newInstance(param1: String, param2: Int): EnvironmentSensorFragment {
            val fragment = EnvironmentSensorFragment()
            val args = Bundle().apply {
                putString(SENSOR_NAME_ARG, param1)
                putInt(SENSOR_TYPE_ARG, param2)
            }
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
}
