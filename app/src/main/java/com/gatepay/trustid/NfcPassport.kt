package com.gatepay.trustid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_add_passport.*

import kotlinx.android.synthetic.main.activity_scan_nfc.*
import kotlinx.android.synthetic.main.activity_scan_nfc.imageView_backbutton

class NfcPassport : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_nfc)


        imageView_backbutton.setOnClickListener {
            val intent = Intent(this, addPassport::class.java)
            startActivity(intent)
        }

        Glide.with(this)
            .asGif()
            .load(R.drawable.nfc_passport_anim_light)
            .into(imageView_instruction_vid_nfc )

    }

}