package com.gatepay.trustid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// TODO switch from singelton to dependency injection

class AuthBottomSheetEx : BottomSheetDialogFragment() {

    private var authenticationBottomSheetListener: authBottomSheetListener?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.activity_bottom_auth_sheet, container, false)

        //handle clicks
        return v
    }

    interface authBottomSheetListener{
        fun onOptionClick(text: String)
    }




    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            authenticationBottomSheetListener = context as authBottomSheetListener?
        }
        catch (e: ClassCastException){
            throw ClassCastException(context.toString())
        }
    }


}