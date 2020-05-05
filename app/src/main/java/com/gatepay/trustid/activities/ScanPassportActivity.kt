package com.gatepay.trustid.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gatepay.trustid.R


import kotlinx.android.synthetic.main.activity_scan_your_passport.*

class ScanPassportActivity  : AppCompatActivity()  {

    private val REQUEST_MRZ = 12

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_your_passport)


//        imageView_backbutton.setOnClickListener {
//            val intent = Intent(this, addPassport::class.java)
//            startActivity(intent)
//        }

        start_scanning_button.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivityForResult(intent, REQUEST_MRZ)
        }
        Glide.with(this)
            .asGif()
            .load(R.drawable.scan_passport_anim_light)
            .into(imageView_instruction_vid)

    }

}