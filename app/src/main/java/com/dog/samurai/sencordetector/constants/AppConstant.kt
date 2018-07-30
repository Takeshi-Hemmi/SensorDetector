package com.dog.samurai.sencordetector.constants

import android.annotation.SuppressLint
import android.hardware.Sensor

class AppConstant {
    companion object {
        @Suppress("DEPRECATION")
        @SuppressLint("InlinedApi")
        val sensorTypeList: List<Int> = mutableListOf(
                Sensor.TYPE_ACCELEROMETER,
                Sensor.TYPE_ACCELEROMETER_UNCALIBRATED,
                Sensor.TYPE_AMBIENT_TEMPERATURE,
                Sensor.TYPE_GAME_ROTATION_VECTOR,
                Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR,
                Sensor.TYPE_GRAVITY,
                Sensor.TYPE_GYROSCOPE,
                Sensor.TYPE_GYROSCOPE_UNCALIBRATED,
                Sensor.TYPE_HEART_BEAT,
                Sensor.TYPE_HEART_RATE,
                Sensor.TYPE_LIGHT,
                Sensor.TYPE_LINEAR_ACCELERATION,
                Sensor.TYPE_MAGNETIC_FIELD,
                Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED,
                Sensor.TYPE_MOTION_DETECT,
                Sensor.TYPE_ORIENTATION,
                Sensor.TYPE_POSE_6DOF,
                Sensor.TYPE_PRESSURE,
                Sensor.TYPE_PROXIMITY,
                Sensor.TYPE_RELATIVE_HUMIDITY,
                Sensor.TYPE_ROTATION_VECTOR,
                Sensor.TYPE_SIGNIFICANT_MOTION,
                Sensor.TYPE_STEP_COUNTER,
                Sensor.TYPE_STEP_DETECTOR,
                Sensor.TYPE_TEMPERATURE
        )
        val sensorNameList: List<String> = mutableListOf(
                "ACCELEROMETER",
                "ACCELEROMETER_UNCALIBRATED",
                "AMBIENT_TEMPERATURE",
                "GAME_ROTATION_VECTOR",
                "GEOMAGNETIC_ROTATION_VECTOR",
                "GRAVITY",
                "GYROSCOPE",
                "GYROSCOPE_UNCALIBRATED",
                "HEART_BEAT(Android 7.0 up)",
                "HEART_RATE(Android 4.4 up)",
                "LIGHT",
                "LINEAR_ACCELERATION",
                "MAGNETIC_FIELD",
                "MAGNETIC_FIELD_UNCALIBRATED",
                "MOTION_DETECT(Android 7.0 up)",
                "ORIENTATION",
                "POSE_6DOF(Android 7.0 up)",
                "PRESSURE",
                "PROXIMITY",
                "RELATIVE_HUMIDITY",
                "ROTATION_VECTOR",
                "SIGNIFICANT_MOTION",
                "STEP_COUNTER",
                "STEP_DETECTOR",
                "TEMPERATURE"
        )

        val sensorNameListJP: List<String> = mutableListOf(
                "加速度計",
                "加速度計（未校正）",
                "周囲温度計",
                "回転ベクトル計",
                "地磁気回転ベクトル計",
                "重力計",
                "ジャイロスコープ",
                "ジャイロスコープ（未校正）",
                "心拍検出",
                "心拍数",
                "照度計",
                "加速度計（重力除外）",
                "地磁気計",
                "地磁気計（未校正）",
                "動作継続検出",
                "傾きセンサー（非推奨）",
                "三次元動作自由度",
                "気圧計",
                "近接センサー",
                "相対湿度計",
                "回転ベクトルセンサー",
                "動作検出",
                "万歩計",
                "歩行検出センサー",
                "温度計（非推奨）"
        )

        const val MOTION_SENSOR: Int = 1
        const val POSITION_SENSOR: Int = 2
        const val ENVIRONMENT_SENSOR: Int = 3

    }
}