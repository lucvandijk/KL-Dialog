package com.kl.dialog.dialogs

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

class AlertDialogue(
    context: Context,
    title: String,
    message: String,
    yesText: String,
    confirmActionCallback: () -> Unit
): AlertDialog.Builder(context) {

    init{
        setTitle(title)
        setMessage(message)

        val listener: DialogInterface.OnClickListener =
            DialogInterface.OnClickListener { _, button ->
                when (button) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        confirmActionCallback()
                    }
                }
            }

        setPositiveButton(yesText, listener)

        setOnCancelListener {
            confirmActionCallback()
        }
    }

}