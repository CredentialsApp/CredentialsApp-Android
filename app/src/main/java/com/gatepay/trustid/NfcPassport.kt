package com.gatepay.trustid


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appliedrec.mrtdreader.BACSpec
import com.appliedrec.mrtdreader.MRTDScanActivity
import com.appliedrec.mrtdreader.MRTDScanResult
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_scan_nfc.*
import java.time.LocalDate
import java.util.*


class NfcPassport : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_nfc)

        //TODO CHECK IF THERE IS NFC READER ON PHONE


        var dateOfBirth = Date()
        var dateOfExpiry = Date()



        val docNumber = intent.getStringExtra("PassportDocNo")
        dateOfBirth = Date("12/20/1996")
            //intent.getStringExtra("PassportDob")

        dateOfBirth = Date("08/24/2024")
            //intent.getStringExtra("PassportDoe")



//        imageView_backbutton.setOnClickListener {
//            val intent = Intent(this, addPassport::class.java)
//            startActivity(intent)
//        }

        Glide.with(this)
            .asGif()
            .load(R.drawable.nfc_passport_anim_light)
            .into(imageView_instruction_vid_nfc )

        start_reading_button.setOnClickListener {
            val bacSpec = BACSpec(docNumber, dateOfBirth, dateOfExpiry)
            val intent = Intent(this, MRTDScanActivity::class.java)
            intent.putExtra(MRTDScanActivity.EXTRA_BAC_SPEC, bacSpec)
            startActivityForResult(intent, 0)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null && data.hasExtra(MRTDScanActivity.EXTRA_MRTD_SCAN_RESULT)) {
            // Scan succeeded
            val scanResult: MRTDScanResult =
                data.getParcelableExtra(MRTDScanActivity.EXTRA_MRTD_SCAN_RESULT)

        } else if (resultCode == Activity.RESULT_OK && data != null && data.hasExtra(MRTDScanActivity.EXTRA_MRTD_SCAN_ERROR)) {

            // Failed to scan the document
            val errorMessage =
                data.getStringExtra(MRTDScanActivity.EXTRA_MRTD_SCAN_ERROR)
        }
    }




}