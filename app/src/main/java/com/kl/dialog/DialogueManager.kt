package com.kl.dialog

import android.content.Context
import android.view.WindowManager

class KLDialogueManager {
    companion object {

        fun alertDialogue(
            context: Context,
            title: String,
            message: String,
            yesText: String,
            confirmationCallback: () -> Unit
        ) {
            AlertDialogue(
                context,
                title,
                message,
                yesText,
                confirmationCallback
            ).show()
        }

        fun yesNoDialogue(
            context: Context,
            title: String,
            message: String,
            yesText: String,
            noText: String,
            yesAction: () -> Unit,
            noAction: () -> Unit
        ) {
            YesNoDialogue(
                context,
                title,
                message,
                yesText,
                noText,
                yesAction,
                noAction
            ).show()
        }







    }
}