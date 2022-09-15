package com.kl.dialog

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

class AlertDialogue(
    context: Context,
    title: String,
    message: String,
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

        setPositiveButton("Ja", listener)

        setOnCancelListener {
            confirmActionCallback()
        }
    }

}