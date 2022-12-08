package com.kl.dialog.dialogs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.kl.dialog.R

/**
 * Dialogue used for requesting a work order check to a specific controller, selected within the  dialogue
 */
class SelectionDialog(
    private val callerContext: Context,
    title: String,
    private val data: ArrayList<String>,
    private val yesText: String,
    private val noText: String,
    private val descriptionText: String,
    private val hintText: String,
    confirmationAction: (Int) -> Unit
) : MaterialAlertDialogBuilder(callerContext) {

    private lateinit var layout: TextInputLayout
    private lateinit var input: MaterialAutoCompleteTextView
    private lateinit var description: TextView
    private lateinit var commentInputLayout: TextInputLayout
    private lateinit var commentInput: TextInputEditText

    private lateinit var requestCheckView: View

    private var selectedIndex = -1

    init {
        initializeView()
        setDropdownListener()
        setTitle(title)
        setView(requestCheckView)

        setPositiveButton(yesText) { _, _ ->
            confirmationAction(selectedIndex)
        }

        // Add to prevent accidentally closing the dialog
        setCancelable(false)
        setNegativeButton(noText) { _, _ -> {
        }}

    }

    /**
     * Create the view object, and set the view element variables
     */
    private fun initializeView() {
        requestCheckView =
            LayoutInflater.from(context).inflate(R.layout.selection_dialog, null, false)
        description = requestCheckView.findViewById(R.id.selection_dialog_description)
        layout =
            requestCheckView.findViewById(R.id.select_dialog_layout)
        input = requestCheckView.findViewById(R.id.select_dialog_input)
        layout.hint = hintText
        description.text = descriptionText
        if(descriptionText.isEmpty())
            description.visibility = View.GONE
    }

    /**
     * Set the dropdown listener for the mechanic selection dropdown
     */
    private fun setDropdownListener() {
        // First set the dropdown adapter
        input.setAdapter(
            ArrayAdapter(
                callerContext,
                R.layout.spinner_dialog_item,
                data
            )
        )

        input.setOnItemClickListener { _, _, position, _ ->
            selectedIndex = position
            input.listSelection = position
        }

    }

}