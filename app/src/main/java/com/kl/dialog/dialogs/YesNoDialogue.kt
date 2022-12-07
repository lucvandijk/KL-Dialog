package com.kl.dialog.dialogs

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

class YesNoDialogue(
    context: Context,
    title: String,
    message: String,
    yesTest: String,
    noText: String,
    confirmActionCallback: () -> Unit,
    denyActionCallback: () -> Unit
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
                    DialogInterface.BUTTON_NEGATIVE -> {
                        denyActionCallback()
                    }
                }
            }

        setPositiveButton(yesTest, listener)
        setNegativeButton(noText, listener)

    }

}