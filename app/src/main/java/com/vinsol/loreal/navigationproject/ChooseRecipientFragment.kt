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
import org.w3c.dom.Text

const val EXTRA_RECIPIENT = "extra_recipient"
class ChooseRecipientFragment : Fragment() {
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.next_btn).setOnClickListener {
            val recipient : TextView = view.findViewById<TextView>(R.id.input_recipient)
            if(recipient.text.isNotBlank()){
                val bundle = bundleOf(EXTRA_RECIPIENT to recipient.text.toString())
                navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment,  bundle)
            }
        }

        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener {
            activity?.onBackPressed()
        }
    }
}