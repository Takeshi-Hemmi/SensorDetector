package com.dog.samurai.sensordetector.sensors

import android.annotation.SuppressLint
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

class MotionSensorFragment : Fragment(), SensorEventListener {

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        event.values.mapIndexed { index, valueFloat ->
            when (index) {
                0 -> param_value1.text = valueFloat.toString()
                1 -> param_value2.text = valueFloat.toString()
                2 -> param_value3.text = valueFloat.toString()
                3 -> param_value4.text = valueFloat.toString()
                4 -> param_value5.text = valueFloat.toString()
                5 -> param_value6.text = valueFloat.toString()
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_sensor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sensorManager = context?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor_name.text = sensorNameArg
        detail_frame.background = ResourcesCompat.getDrawable(resources, R.drawable.shape_circle_normal, null)
        detail_icon.setImageResource(R.drawable.ic_motion)

        when (sensorNameArg) {
            "ACCELEROMETER" -> {
                sensor_description.text = resources.getString(R.string.motion_accelerometer_desc)

                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.motion_accelerometer_key1)

                param_container2.visibility = View.VISIBLE
                param_key2.text = resources.getString(R.string.motion_accelerometer_key2)

                param_container3.visibility = View.VISIBLE
                param_key3.text = resources.getString(R.string.motion_accelerometer_key3)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
                sensor_info.text = "Vendor: ${sensor.vendor} \n単位: m/s2"


            }
            "ACCELEROMETER_UNCALIBRATED" -> {
                sensor_description.text = resources.getString(R.string.motion_accelerometer_uncalibrated_desc)
                param_key1.text = resources.getString(R.string.motion_accelerometer_uncalibrated_title)
                @SuppressLint("InlinedApi")
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER_UNCALIBRATED)
            }
            "GRAVITY" -> {
                sensor_description.text = resources.getString(R.string.motion_gravity_desc)
                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.motion_gravity_key1)

                param_container2.visibility = View.VISIBLE
                param_key2.text = resources.getString(R.string.motion_gravity_key2)

                param_container3.visibility = View.VISIBLE
                param_key3.text = resources.getString(R.string.motion_gravity_key3)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
                sensor_info.text = "Vendor: ${sensor.vendor} \n単位: m/s2"
            }
            "GYROSCOPE" -> {
                sensor_description.text = resources.getString(R.string.motion_gyroscope_desc)
                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.motion_gyroscope_key1)

                param_container2.visibility = View.VISIBLE
                param_key2.text = resources.getString(R.string.motion_gyroscope_key2)

                param_container3.visibility = View.VISIBLE
                param_key3.text = resources.getString(R.string.motion_gyroscope_key3)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
                sensor_info.text = "Vendor: ${sensor.vendor} \n単位: rad/s"
            }
            "GYROSCOPE_UNCALIBRATED" -> {
                sensor_description.text = resources.getString(R.string.motion_gyroscope_uncalibrated_desc)
                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.motion_gyroscope_uncalibrated_key1)

                param_container2.visibility = View.VISIBLE
                param_key2.text = resources.getString(R.string.motion_gyroscope_uncalibrated_key2)

                param_container3.visibility = View.VISIBLE
                param_key3.text = resources.getString(R.string.motion_gyroscope_uncalibrated_key3)

                param_container4.visibility = View.VISIBLE
                param_key4.text = resources.getString(R.string.motion_gyroscope_uncalibrated_key4)

                param_container5.visibility = View.VISIBLE
                param_key5.text = resources.getString(R.string.motion_gyroscope_uncalibrated_key5)

                param_container6.visibility = View.VISIBLE
                param_key6.text = resources.getString(R.string.motion_gyroscope_uncalibrated_key6)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE_UNCALIBRATED)
                sensor_info.text = "Vendor: ${sensor.vendor} \n単位: rad/s"
            }
            "LINEAR_ACCELERATION" -> {
                sensor_description.text = resources.getString(R.string.motion_linear_acceleration_desc)
                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.motion_linear_acceleration_key1)

                param_container2.visibility = View.VISIBLE
                param_key2.text = resources.getString(R.string.motion_linear_acceleration_key2)

                param_container3.visibility = View.VISIBLE
                param_key3.text = resources.getString(R.string.motion_linear_acceleration_key3)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)
                sensor_info.text = "Vendor: ${sensor.vendor} \n単位: m/s2"
            }
            "ROTATION_VECTOR" -> {
                sensor_description.text = resources.getString(R.string.motion_rotation_vector_desc)
                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.motion_rotation_vector_key1)

                param_container2.visibility = View.VISIBLE
                param_key2.text = resources.getString(R.string.motion_rotation_vector_key2)

                param_container3.visibility = View.VISIBLE
                param_key3.text = resources.getString(R.string.motion_rotation_vector_key3)

                param_container4.visibility = View.VISIBLE
                param_key4.text = resources.getString(R.string.motion_rotation_vector_key4)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
                sensor_info.text = "Vendor: ${sensor.vendor}"
            }
            "SIGNIFICANT_MOTION" -> {
                sensor_description.text = resources.getString(R.string.motion_significant_motion_desc)
                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.motion_significant_motion_title)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION)
                sensor_info.text = "Vendor: ${sensor.vendor}"

            }
            "STEP_COUNTER" -> {
                sensor_description.text = resources.getString(R.string.motion_step_counter_desc)
                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.motion_step_counter_title)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
                sensor_info.text = "Vendor: ${sensor.vendor}"
            }
            "STEP_DETECTOR" -> {
                sensor_description.text = resources.getString(R.string.motion_step_detector_desc)
                param_container1.visibility = View.VISIBLE
                param_key1.text = resources.getString(R.string.motion_step_counter_title)

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)
                sensor_info.text = "Vendor: ${sensor.vendor} "
            }
            else -> {
                activity?.supportFragmentManager?.popBackStack()
            }

        }

    }

    companion object {
        private const val SENSOR_NAME_ARG = "sensorName"
        private const val SENSOR_TYPE_ARG = "sensorType"

        fun newInstance(param1: String, param2: Int): MotionSensorFragment {
            val fragment = MotionSensorFragment()
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
