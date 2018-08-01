package com.dog.samurai.sensordetector

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater

class HelpFragmentDialog : DialogFragment() {

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return AlertDialog
                .Builder(context!!)
                .apply {
                    setView((activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.fragment_help, null))
                    setPositiveButton("OK", null)
                }
                .create()
    }

}