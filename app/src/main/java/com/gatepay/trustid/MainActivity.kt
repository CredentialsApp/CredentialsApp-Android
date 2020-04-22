package com.gatepay.trustid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.LinearLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_my_crendentials.*


class MainActivity : AppCompatActivity(), BottomSheetEx.BottomSheetListener {

// TODO ADD ANDROID NATIVE BACK BUTTON
// TODO IMPLEMENT BOTTOM SHEET
// TODO fix bottom sheet design


    private lateinit var sheetBehavior: BottomSheetBehavior<LinearLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_crendentials)

        add_credentials_button.setOnClickListener {
                    val bottomSheet = BottomSheetEx()
                    bottomSheet.show(supportFragmentManager, "BottomSheetEx")
                }
    }

    override fun onOptionClick(text: String) {
        TODO("Not yet implemented")
    }

}