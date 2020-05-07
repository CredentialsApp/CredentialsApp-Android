package com.gatepay.trustid.activities


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gatepay.trustid.IntentData
import com.gatepay.trustid.R
import kotlinx.android.synthetic.main.activity_scan_nfc.*
import org.jmrtd.lds.icao.MRZInfo


class NfcPassportActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_nfc)


        val  mrzInfo = intent.getSerializableExtra(IntentData.KEY_MRZ_INFO) as MRZInfo




//        imageView_backbutton.setOnClickListener {
//            val intent = Intent(this, addPassport::class.java)
//            startActivity(intent)
//        }

        Glide.with(this)
            .asGif()
            .load(R.drawable.nfc_passport_anim_light)
            .into(imageView_instruction_vid_nfc )

        start_reading_button.setOnClickListener {
            val intent = Intent(this, NfcReadingActivity::class.java)
//                intent.putExtra("PassportDocNo", passportDocumentNo)
//                intent.putExtra("PassportDob", passportDob)
//                intent.putExtra("PassportDoe", passportDoe)
            intent.putExtra(IntentData.KEY_MRZ_INFO, mrzInfo)
            startActivity(intent)
        }

    }





}