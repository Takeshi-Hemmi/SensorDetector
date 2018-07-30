package com.dog.samurai.sencordetector

import android.content.Context
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.transition.Fade
import android.view.Menu
import android.view.MenuItem
import com.dog.samurai.sencordetector.constants.AppConstant
import com.dog.samurai.sencordetector.constants.AppConstant.Companion.sensorNameList

class MainActivity : AppCompatActivity() {

    val enabledList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppConstant.sensorTypeList.mapIndexed { index, type ->
            if (((getSystemService(Context.SENSOR_SERVICE) as SensorManager).getDefaultSensor(type)) != null) {
                enabledList.add(sensorNameList[index])
            }
        }
        renderFragment(TopFragment())
    }

    fun renderFragment(fragment: Fragment?) {
        if (fragment == null) return

        fragment.enterTransition = Fade()
        val transaction = supportFragmentManager.beginTransaction()
        if (fragment is TopFragment) {
            transaction.add(R.id.contentFrame, fragment)
        } else {
            transaction.replace(R.id.contentFrame, fragment)
        }
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.help, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val helpFragment = HelpFragmentDialog()
        helpFragment.isCancelable = false
        helpFragment.show(supportFragmentManager, "help")

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            super.onBackPressed()
        }
    }
}


