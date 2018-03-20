package com.dog.samurai.sencordetector.sensors

import android.annotation.SuppressLint
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

class MotionSensorFragment : Fragment(), SensorEventListener {

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        event.values.mapIndexed { index, valueFloat ->
            when (index) {
                0 -> {
                    parameterText.apply {
                        visibility = View.VISIBLE
                        text = valueFloat.toString()
                    }
                }
                1 -> {
                    parameterText2.apply {
                        visibility = View.VISIBLE
                        text = valueFloat.toString()
                    }
                }
                2 -> {
                    parameterText3.apply {
                        visibility = View.VISIBLE
                        text = valueFloat.toString()
                    }
                }
                3 -> {
                    parameterText4.apply {
                        visibility = View.VISIBLE
                        text = valueFloat.toString()
                    }
                }
                4 -> {
                    parameterText5.apply {
                        visibility = View.VISIBLE
                        text = valueFloat.toString()
                    }
                }
                5 -> {
                    parameterText6.apply {
                        visibility = View.VISIBLE
                        text = valueFloat.toString()
                    }
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

        when (sensorNameArg) {
            "ACCELEROMETER" -> {
                sensorDescription.text = resources.getString(R.string.motion_accelerometer_desc)

                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = "X軸（重力を含む）に沿った加速力"
                }
                paramNameText2.apply {
                    visibility = View.VISIBLE
                    text = "Y軸（重力を含む）に沿った加速力"
                }
                paramNameText3.apply {
                    visibility = View.VISIBLE
                    text = "Z軸（重力を含む）に沿った加速力"
                }
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
                sensorInfo.text = "Vendor: ${sensor.vendor} \n単位: m/s2"


            }
            "ACCELEROMETER_UNCALIBRATED" -> {
                sensorDescription.text = resources.getString(R.string.motion_accelerometer_uncalibrated_desc)
                paramNameText.text = resources.getString(R.string.motion_accelerometer_uncalibrated_title)
                @SuppressLint("InlinedApi")
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER_UNCALIBRATED)
            }
            "GRAVITY" -> {
                sensorDescription.text = resources.getString(R.string.motion_gravity_desc)
                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = "X軸に沿った重力"
                }
                paramNameText2.apply {
                    visibility = View.VISIBLE
                    text = "Y軸に沿った重力"
                }
                paramNameText3.apply {
                    visibility = View.VISIBLE
                    text = "Z軸に沿った重力"
                }
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
                sensorInfo.text = "Vendor: ${sensor.vendor} \n単位: m/s2"
            }
            "GYROSCOPE" -> {
                sensorDescription.text = resources.getString(R.string.motion_gyroscope_desc)
                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = "X軸周りの回転速度"
                }
                paramNameText2.apply {
                    visibility = View.VISIBLE
                    text = "Y軸周りの回転速度"
                }
                paramNameText3.apply {
                    visibility = View.VISIBLE
                    text = "Z軸周りの回転速度"
                }
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
                sensorInfo.text = "Vendor: ${sensor.vendor} \n単位: rad/s"
            }
            "GYROSCOPE_UNCALIBRATED" -> {
                sensorDescription.text = resources.getString(R.string.motion_gyroscope_uncalibrated_desc)
                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = "X軸周りの回転速度（ドリフト補償なし）"
                }
                paramNameText2.apply {
                    visibility = View.VISIBLE
                    text = "Y軸周りの回転速度（ドリフト補償なし）"
                }
                paramNameText3.apply {
                    visibility = View.VISIBLE
                    text = "Z軸周りの回転速度（ドリフト補償なし）"
                }
                paramNameText4.apply {
                    visibility = View.VISIBLE
                    text = "X軸周りの推定ドリフト"
                }
                paramNameText5.apply {
                    visibility = View.VISIBLE
                    text = "Y軸周りの推定ドリフト"
                }
                paramNameText6.apply {
                    visibility = View.VISIBLE
                    text = "Z軸周りの推定ドリフト"
                }
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE_UNCALIBRATED)
                sensorInfo.text = "Vendor: ${sensor.vendor} \n単位: rad/s"
            }
            "LINEAR_ACCELERATION" -> {
                sensorDescription.text = resources.getString(R.string.motion_linear_acceleration_desc)
                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = "X軸に沿った加速力（重力を除く）"
                }
                paramNameText2.apply {
                    visibility = View.VISIBLE
                    text = "Y軸に沿った加速力（重力を除く）"
                }
                paramNameText3.apply {
                    visibility = View.VISIBLE
                    text = "Y軸に沿った加速力（重力を除く）"
                }
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)
                sensorInfo.text = "Vendor: ${sensor.vendor} \n単位: m/s2"
            }
            "ROTATION_VECTOR" -> {
                sensorDescription.text = resources.getString(R.string.motion_rotation_vector_desc)
                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = "X軸に沿った回転ベクトル成分(x * sin(θ/2))"
                }
                paramNameText2.apply {
                    visibility = View.VISIBLE
                    text = "Y軸に沿った回転ベクトル成分(x * sin(θ/2))"
                }
                paramNameText3.apply {
                    visibility = View.VISIBLE
                    text = "Y軸に沿った回転ベクトル成分(x * sin(θ/2))"
                }
                paramNameText4.apply {
                    visibility = View.VISIBLE
                    text = "回転ベクトルのスカラー成分((cos(θ/2))"
                }
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
                sensorInfo.text = "Vendor: ${sensor.vendor}"
            }
            "SIGNIFICANT_MOTION" -> {
                sensorDescription.text = resources.getString(R.string.motion_significant_motion_desc)
                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = resources.getString(R.string.motion_significant_motion_title)
                }
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION)
                sensorInfo.text = "Vendor: ${sensor.vendor}"

            }
            "STEP_COUNTER" -> {
                sensorDescription.text = resources.getString(R.string.motion_step_counter_desc)
                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = resources.getString(R.string.motion_step_counter_title)
                }
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
                sensorInfo.text = "Vendor: ${sensor.vendor}"
            }
            "STEP_DETECTOR" -> {
                sensorDescription.text = resources.getString(R.string.motion_step_detector_desc)
                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = resources.getString(R.string.motion_step_counter_title)
                }
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)
                sensorInfo.text = "Vendor: ${sensor.vendor} "
            }
            else -> {
                activity.supportFragmentManager.popBackStack()
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
