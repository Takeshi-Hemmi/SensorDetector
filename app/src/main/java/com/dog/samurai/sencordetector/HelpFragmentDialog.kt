package com.dog.samurai.sencordetector

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HelpFragmentDialog : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBuilder = AlertDialog.Builder(context!!)
        val inflater = (activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
        val content = inflater.inflate(R.layout.fragment_help, null)
        dialogBuilder.setView(content)
        dialogBuilder.setPositiveButton("OK", null)
        return dialogBuilder.create()
    }

}