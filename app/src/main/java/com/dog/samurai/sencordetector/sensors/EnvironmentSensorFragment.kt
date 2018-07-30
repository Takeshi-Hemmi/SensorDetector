package com.dog.samurai.sencordetector.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dog.samurai.sencordetector.R
import kotlinx.android.synthetic.main.fragment_detail_sensor.*

class EnvironmentSensorFragment : Fragment(), SensorEventListener {

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        param_value1.text = event.values[0].toString()
    }

    private lateinit var sensorManager: SensorManager
    private lateinit var sensor: Sensor
    private var sensorNameArg: String? = null
    private var sensorTypeArg: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (arguments != null) {
            sensorNameArg = arguments!!.getString(SENSOR_NAME_ARG)
            sensorTypeArg = arguments!!.getInt(SENSOR_TYPE_ARG)
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_sensor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sensorManager = context?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor_name.text = sensorNameArg
        detail_frame.background = ResourcesCompat.getDrawable(resources, R.drawable.shape_circle_light, null)
        detail_icon.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_environment, null))
        param_container1.visibility = View.VISIBLE

        when (sensorNameArg) {
            "AMBIENT_TEMPERATURE" -> {
                sensor_description.text = resources.getString(R.string.environ_ambient_temperate_desc)
                param_key1.text = resources.getString(R.string.environ_ambient_temperate_title)
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
                sensor_info.text = "Vendor: ${sensor.vendor} \n単位: ℃"
            }
            "LIGHT" -> {
                sensor_description.text = resources.getString(R.string.environ_light_desc)
                param_key1.text = resources.getString(R.string.environ_light_title)
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
                sensor_info.text = "Vendor: ${sensor.vendor} \n単位: lx"
            }
            "PRESSURE" -> {
                sensor_description.text = resources.getString(R.string.environ_pressure_desc)
                param_key1.text = resources.getString(R.string.environ_pressure_title)
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)
                sensor_info.text = "Vendor: ${sensor.vendor} \n単位: hPa"
            }
            "RELATIVE_HUMIDITY" -> {
                sensor_description.text = resources.getString(R.string.environ_relative_humidity_desc)
                param_key1.text = resources.getString(R.string.environ_relative_humidity_title)
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY)
                sensor_info.text = "Vendor: ${sensor.vendor} \n単位: %"
            }
            "TEMPERATURE" -> {
                sensor_description.text = resources.getString(R.string.environ_temperate_desc)
                param_key1.text = resources.getString(R.string.environ_temperate_title)
                @Suppress("DEPRECATION")
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE)
                sensor_info.text = "Vendor: ${sensor.vendor} \n単位: ℃"
            }
            else -> {
                activity?.supportFragmentManager?.popBackStack()
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
