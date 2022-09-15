package com.kl.dialog

import android.content.Context
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class KLDialogueManager {
    companion object {

        fun alertDialogue(
            context: Context,
            title: String,
            message: String,
            confirmationCallback: () -> Unit
        ) {
            AlertDialogue(
                context,
                title,
                message,
                confirmationCallback
            ).show()
        }

    }
}