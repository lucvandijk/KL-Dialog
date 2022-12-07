package com.kl.dialog.dialogs

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SelectionDialogue(
    context: Context,
    title: String,
    labels: Array<String>,
    selectionAction: (Int) -> Unit
): MaterialAlertDialogBuilder(context) {

    init{
        setTitle(title)
        setItems(labels){ _, which ->
            selectionAction(which)
        }
    }

}


