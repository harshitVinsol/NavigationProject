package com.vinsol.loreal.navigationproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

const val EXTRA_AMOUNT = "extra_amount"

class SpecifyAmountFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments?.getString(EXTRA_RECIPIENT, "") ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val message = "Sending money to $recipient"
        view.findViewById<TextView>(R.id.recipient).text = message
        view.findViewById<Button>(R.id.send_btn).setOnClickListener {
            val amount: TextView = view.findViewById(R.id.input_amount)
            if (amount.text.toString().isNotBlank()) {
                val money = amount.text.toString().toInt()
                val args = bundleOf(EXTRA_RECIPIENT to recipient, EXTRA_AMOUNT to money)
                navController.navigate(
                    R.id.action_specifyAmountFragment_to_confirmationFragment,
                    args
                )
            }
        }

        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener {
            activity?.onBackPressed()
        }
    }
}