package com.vinsol.loreal.navigationproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class ConfirmationFragment : Fragment() {
    private val recipient: String by lazy { arguments?.getString(EXTRA_RECIPIENT, "") ?: "" }
    private val amount: Int by lazy { arguments?.getInt(EXTRA_AMOUNT, 0) ?: 0 }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.confirmation_message).text =
            "You have sent Rs. $amount to $recipient."
    }
}