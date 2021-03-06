package com.dog.samurai.sensordetector.sensors

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
import com.dog.samurai.sensordetector.R
import kotlinx.android.synthetic.main.fragment_detail_sensor.*

class PositionSensorFragment : Fragment(), SensorEventListener {

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        event.values.mapIndexed { index, valueFloat ->
            when (index) {
                0 -> {
                    param_value1.text = valueFloat.toString()
                }
                1 -> {
                    param_container2.visibility = View.VISIBLE
                    param_value2.text = valueFloat.toString()
                }
                2 -> {
                    param_container3.visibility = View.VISIBLE
                    param_value3.text = valueFloat.toString()
                }

                3 -> {
                    param_container4.visibility = View.VISIBLE
                    param_value4.text = valueFloat.toString()
                }
                4 -> {
                    param_container5.visibility = View.VISIBLE
                    param_value5.text = valueFloat.toString()
                }
                5 -> {
                    param_container6.visibility = View.VISIBLE
                    param_value6.text = valueFloat.toString()
                }
                else -> {
                }
            }
        }
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

        return inflater.inflate(R.layout.fragment_detail_sensor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sensorManager = context?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor_name.text = sensorNameArg
        detail_frame.background = ResourcesCompat.getDrawable(resources, R.drawable.shape_circle_dark, null)
//        detail_icon.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_position, null))
        detail_icon.setImageResource(R.drawable.ic_position)
        when (sensorNameArg) {
            "GAME_ROTATION_VECTOR" -> {
                sensor_description.text = resources.getString(R.string.position_game_rotation_vector_desc)

                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.position_geomagnetic_rotation_vector_key1)

                param_container2.visibility = View.VISIBLE
                param_key2.text = resources.getString(R.string.position_geomagnetic_rotation_vector_key2)

                param_container3.visibility = View.VISIBLE
                param_key3.text = resources.getString(R.string.position_geomagnetic_rotation_vector_key3)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR)
                sensor_info.text = "Vendor: ${sensor.vendor}"
            }
            "GEOMAGNETIC_ROTATION_VECTOR" -> {
                sensor_description.text = resources.getString(R.string.position_geomagnetic_rotation_vector_desc)
                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.position_geomagnetic_rotation_vector_key1)

                param_container2.visibility = View.VISIBLE
                param_key2.text = resources.getString(R.string.position_geomagnetic_rotation_vector_key2)

                param_container3.visibility = View.VISIBLE
                param_key3.text = resources.getString(R.string.position_geomagnetic_rotation_vector_key3)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR)
                sensor_info.text = "Vendor: ${sensor.vendor}"
            }
            "MAGNETIC_FIELD" -> {
                sensor_description.text = resources.getString(R.string.position_magnetic_field_desc)
                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.position_magnetic_field_key1)

                param_container2.visibility = View.VISIBLE
                param_key2.text = resources.getString(R.string.position_magnetic_field_key2)

                param_container3.visibility = View.VISIBLE
                param_key3.text = resources.getString(R.string.position_magnetic_field_key3)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
                sensor_info.text = "Vendor: ${sensor.vendor} \n単位: μT"
            }
            "MAGNETIC_FIELD_UNCALIBRATED" -> {
                sensor_description.text = resources.getString(R.string.position_magnetic_field_uncalibrated_desc)
                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.position_magnetic_field_uncalibrated_key1)

                param_container2.visibility = View.VISIBLE
                param_key2.text = resources.getString(R.string.position_magnetic_field_uncalibrated_key2)

                param_container3.visibility = View.VISIBLE
                param_key3.text = resources.getString(R.string.position_magnetic_field_uncalibrated_key3)

                param_container4.visibility = View.VISIBLE
                param_key4.text = resources.getString(R.string.position_magnetic_field_uncalibrated_key4)

                param_container5.visibility = View.VISIBLE
                param_key5.text = resources.getString(R.string.position_magnetic_field_uncalibrated_key5)

                param_container6.visibility = View.VISIBLE
                param_key6.text = resources.getString(R.string.position_magnetic_field_uncalibrated_key6)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED)
                sensor_info.text = "Vendor: ${sensor.vendor} \n単位: μT"
            }
            "ORIENTATION" -> {
                sensor_description.text = resources.getString(R.string.position_orientation_desc)
                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.position_orientation_key1)

                param_container2.visibility = View.VISIBLE
                param_key2.text = resources.getString(R.string.position_orientation_key2)

                param_container3.visibility = View.VISIBLE
                param_key3.text = resources.getString(R.string.position_orientation_key3)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION)
                sensor_info.text = "Vendor: ${sensor.vendor} \n単位: 度"
            }
            "PROXIMITY" -> {
                sensor_description.text = resources.getString(R.string.position_proximity_desc)
                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.position_proximity_key)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
                sensor_info.text = "Vendor: ${sensor.vendor} \n単位: cm"
            }

            else -> {
                activity?.supportFragmentManager?.popBackStack()
            }
        }
    }

    companion object {
        private const val SENSOR_NAME_ARG = "sensorName"
        private const val SENSOR_TYPE_ARG = "sensorType"

        fun newInstance(param1: String, param2: Int): PositionSensorFragment {
            val fragment = PositionSensorFragment()
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
