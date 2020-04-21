package com.gatepay.trustid

import android.content.Context
import android.content.Intent
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_bottom_sheet.*
import kotlinx.android.synthetic.main.activity_bottom_sheet.view.*


class BottomSheetEx : BottomSheetDialogFragment() {

    private var mBottomSheetListener: BottomSheetListener?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.activity_bottom_sheet, container, false)

        //handle clicks

        v.passwordBtn.setOnClickListener {
            val intent = Intent (getActivity(), addPassport::class.java)
            getActivity()!!.startActivity(intent)
        }

        v.idCardBtn.setOnClickListener {

        }

        v.drivingLicenseBtn.setOnClickListener {

        }

        v.cancelBtn.setOnClickListener {

        }
        return v
    }

    interface BottomSheetListener{
        fun onOptionClick(text: String)
    }




    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mBottomSheetListener = context as BottomSheetListener?
        }
        catch (e: ClassCastException){
            throw ClassCastException(context.toString())
        }
    }


}