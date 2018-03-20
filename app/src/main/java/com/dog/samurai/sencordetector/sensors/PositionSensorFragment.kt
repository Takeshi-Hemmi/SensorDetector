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

class PositionSensorFragment : Fragment(), SensorEventListener {

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
            "GAME_ROTATION_VECTOR" -> {
                sensorDescription.text = resources.getString(R.string.position_game_rotation_vector_desc)

                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = "X軸に沿った回転ベクトル成分(x * sin(θ/2))"
                }
                paramNameText2.apply {
                    visibility = View.VISIBLE
                    text = "Y軸に沿った回転ベクトル成分(y * sin(θ/2))"
                }
                paramNameText3.apply {
                    visibility = View.VISIBLE
                    text = "Z軸に沿った回転ベクトル成分(z * sin(θ/2))"
                }
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR)
                sensorInfo.text = "Vendor: ${sensor.vendor}"


            }
            "GEOMAGNETIC_ROTATION_VECTOR" -> {
                sensorDescription.text = resources.getString(R.string.position_geomagnetic_rotation_vector_desc)
                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = "X軸に沿った回転ベクトル成分(x * sin(θ/2))"
                }
                paramNameText2.apply {
                    visibility = View.VISIBLE
                    text = "Y軸に沿った回転ベクトル成分(y * sin(θ/2))"
                }
                paramNameText3.apply {
                    visibility = View.VISIBLE
                    text = "Z軸に沿った回転ベクトル成分(z * sin(θ/2))"
                }
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR)
                sensorInfo.text = "Vendor: ${sensor.vendor}"
            }
            "MAGNETIC_FIELD" -> {
                sensorDescription.text = resources.getString(R.string.position_magnetic_field_desc)
                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = "X軸に沿った地磁気の強さ"
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
                sensorInfo.text = "Vendor: ${sensor.vendor} \n単位: μT"
            }
            "MAGNETIC_FIELD_UNCALIBRATED" -> {
                sensorDescription.text = resources.getString(R.string.position_magnetic_field_uncalibrated_desc)
                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = "X軸に沿った地磁気強度（ハードアイアン較正なし）"
                }
                paramNameText2.apply {
                    visibility = View.VISIBLE
                    text = "Y軸に沿った地磁気強度（ハードアイアン較正なし）"
                }
                paramNameText3.apply {
                    visibility = View.VISIBLE
                    text = "Z軸に沿った地磁気強度（ハードアイアン較正なし）"
                }
                paramNameText4.apply {
                    visibility = View.VISIBLE
                    text = "X軸に沿ったアイアンバイアスの推定量"
                }
                paramNameText5.apply {
                    visibility = View.VISIBLE
                    text = "Y軸に沿ったアイアンバイアスの推定量"
                }
                paramNameText6.apply {
                    visibility = View.VISIBLE
                    text = "Z軸に沿ったアイアンバイアスの推定量"
                }

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
                sensorInfo.text = "Vendor: ${sensor.vendor} \n単位: μT"
            }
            "ORIENTATION" -> {
                sensorDescription.text = resources.getString(R.string.position_orientation_desc)
                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = "Azimuth: 方位角（z軸周りの角度）"
                }
                paramNameText2.apply {
                    visibility = View.VISIBLE
                    text = "Pitch: ピッチ（x軸周りの角度）"
                }
                paramNameText3.apply {
                    visibility = View.VISIBLE
                    text = "Roll: ロール（y軸周りの角度）"
                }

                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE_UNCALIBRATED)
                sensorInfo.text = "Vendor: ${sensor.vendor} \n単位: 度"
            }
            "PROXIMITY" -> {
                sensorDescription.text = resources.getString(R.string.position_proximity_desc)
                paramNameText.apply {
                    visibility = View.VISIBLE
                    text = "オブジェクトからの距離"
                }
                sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)
                sensorInfo.text = "Vendor: ${sensor.vendor} \n単位: cm"
            }

            else -> {
                activity.supportFragmentManager.popBackStack()
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
