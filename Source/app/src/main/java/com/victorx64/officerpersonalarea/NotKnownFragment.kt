package com.example.healthyworker

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.victorx64.officerpersonalarea.R

class NotKnownFragment: Fragment() {
    companion object {
        fun newInstance(s: String): NotKnownFragment{
            return NotKnownFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.not_known_layout,container,false)
    }
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }
}