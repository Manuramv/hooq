package com.example.hqtv.customcomponents

import android.content.Context
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import com.example.hqtv.R
import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import androidx.databinding.adapters.TextViewBindingAdapter.setText

import android.widget.EditText
import android.view.LayoutInflater
import android.app.Activity
import android.content.DialogInterface
import android.view.View


/**
 * Created by manuramv on 2020-03-03.
 */
class HqAlertDialog(val mContext : Context) {

    fun errorAlertDialog(msg: String,onReload:() -> Unit){
        val activity = mContext as Activity
         val hqALertBuilder: AlertDialog.Builder =  AlertDialog.Builder(activity);
        // Get the layout inflater
        val inflater: LayoutInflater = activity.getLayoutInflater();
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the
        // dialog layout
        hqALertBuilder.setCancelable(false);
        //builder.setIcon(com.example.hqtv.R.drawable.galleryalart);
        hqALertBuilder.setView(inflater.inflate(R.layout.custom_hq_error_dialog, null))
        hqALertBuilder.create();
        hqALertBuilder.show();







/*
        val dialogBuilder = AlertDialog.Builder(mContext)

        val builder = AlertDialog.Builder(mContext)
        builder.setTitle(mContext.getString(R.string.error_title))
        builder.setMessage(msg)
        builder.setPositiveButton(mContext.getString(R.string.retry_title)){dialog, which ->
            onReload.invoke()
            dialog.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()*/
    }

    fun showLoadingProgressBar(msg: String){
        // Create progressBar dynamically...
        val proDialog = ProgressDialog(mContext)
        proDialog.setCancelable(false)
        proDialog.setMessage(msg)
        proDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        proDialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        proDialog.show()

    }

    fun hideProgressBar() {

    }


}