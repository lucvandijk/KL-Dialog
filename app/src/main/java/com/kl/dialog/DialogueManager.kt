package com.kl.dialog

import android.content.Context
import com.kl.dialog.dialogs.AlertDialogue
import com.kl.dialog.dialogs.SelectionDialog
import com.kl.dialog.dialogs.YesNoDialog

class KLDialogueManager {
    companion object {

        fun alertDialog(
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

        fun yesNoDialog(
            context: Context,
            title: String,
            message: String,
            yesText: String,
            noText: String,
            yesAction: () -> Unit,
            noAction: () -> Unit
        ) {
            YesNoDialog(
                context,
                title,
                message,
                yesText,
                noText,
                yesAction,
                noAction
            ).show()
        }

        fun selectionDialog(
            context: Context,
            title: String,
            items: ArrayList<String>,
            yesText: String,
            noText: String,
            descriptionText: String,
            hintText: String,
            selectionAction: (Int) -> Unit
        ) {
            SelectionDialog(
                context,
                title,
                items,
                yesText,
                noText,
                descriptionText,
                hintText,
                selectionAction,
            ).show()
        }

    }
}