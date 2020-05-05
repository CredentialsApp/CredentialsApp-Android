package com.gatepay.trustid.activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gatepay.trustid.R
import kotlinx.android.synthetic.main.activity_scan_nfc.*


class NfcPassportActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_nfc)

        //TODO CHECK IF THERE IS NFC READER ON PHONE





//        imageView_backbutton.setOnClickListener {
//            val intent = Intent(this, addPassport::class.java)
//            startActivity(intent)
//        }

        Glide.with(this)
            .asGif()
            .load(R.drawable.nfc_passport_anim_light)
            .into(imageView_instruction_vid_nfc )

        start_reading_button.setOnClickListener {

        }

    }





}