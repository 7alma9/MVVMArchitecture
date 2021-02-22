package com.xammy.mvvmarchitecture.util


import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.xammy.mvvmarchitecture.R

/**
@author Salman Aziz
created on 2/22/21
 **/

object DialogUtils {

    private lateinit var dialog: AlertDialog

    fun createProgressDialog(context: Context, cancelable: Boolean): Dialog {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //dialog.window!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        dialog.setContentView(R.layout.dialog_progress)
        dialog.setCanceledOnTouchOutside(cancelable)
        dialog.setCancelable(cancelable)
        return dialog
    }

    fun createSimpleAlertDialog(
        context: Context,
        @StringRes titleId: Int = R.string.please_confirm,
        messageId: Any,
        @StringRes positiveButtonText: Int = R.string.okay,
        positiveClickListener: DialogInterface.OnClickListener? = null,
        @StringRes negativeButtonText: Int = -1,
        cancelable: Boolean = true
    ) {
        if (this::dialog.isInitialized && dialog.isShowing) {
            return
        }
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.apply {
            if (titleId != -1)
                setTitle(titleId)
            if (messageId is String)
                setMessage(messageId)
            if (messageId is Int && messageId != -1)
                setMessage(messageId)
            if (positiveButtonText != -1)
                setPositiveButton(positiveButtonText, positiveClickListener)
            if (negativeButtonText != -1)
                setNegativeButton(negativeButtonText, null)
            setCancelable(cancelable)
        }
        dialog = dialogBuilder.create()
        dialog.show()
        dialog.getButton(DialogInterface.BUTTON_POSITIVE)?.isAllCaps = false
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE)?.isAllCaps = false
        dialog.getButton(DialogInterface.BUTTON_NEUTRAL)?.isAllCaps = false
    }
}