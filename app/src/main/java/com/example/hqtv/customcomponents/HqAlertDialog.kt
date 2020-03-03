package com.example.hqtv.customcomponents

import android.content.Context
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import com.example.hqtv.R
import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window


/**
 * Created by manuramv on 2020-03-03.
 */
class HqAlertDialog(val mContext : Context) {

    fun errorAlertDialog(msg: String,onReload:() -> Unit){
        val builder = AlertDialog.Builder(mContext)
        builder.setTitle(mContext.getString(R.string.error_title))
        builder.setMessage(msg)
        builder.setPositiveButton(mContext.getString(R.string.retry_title)){dialog, which ->
            onReload.invoke()
            dialog.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
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