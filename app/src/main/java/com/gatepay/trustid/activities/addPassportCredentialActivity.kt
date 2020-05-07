package com.gatepay.trustid.activities


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gatepay.trustid.IntentData
import com.gatepay.trustid.R
import com.google.android.material.snackbar.Snackbar


import kotlinx.android.synthetic.main.activity_add_passport.*
import org.jmrtd.lds.icao.MRZInfo


class addPassportCredentialActivity : AppCompatActivity() {

    private var mrzInfo: MRZInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_passport)
        val intent = intent
        if (intent.hasExtra(IntentData.KEY_MRZ_INFO)) {
            mrzInfo = intent.getSerializableExtra(IntentData.KEY_MRZ_INFO) as MRZInfo
        }
//
//        val passportDocumentNo = intent.getStringExtra("KEY_MRZ_INFO_DOC_NO")
//        val passportDob = intent.getStringExtra("KEY_MRZ_INFO_DOB")
//        val passportDoe =intent.getStringExtra("KEY_MRZ_INFO_DOE")




        if (mrzInfo != null){
            imageView_addPassport.isEnabled = false
            imageView_addPassport.setImageResource(R.drawable.scan_passport_done_btn)



            imageView_addNFC.setOnClickListener {
                val intent = Intent(this, NfcPassportActivity::class.java)
//                intent.putExtra("PassportDocNo", passportDocumentNo)
//                intent.putExtra("PassportDob", passportDob)
//                intent.putExtra("PassportDoe", passportDoe)
                intent.putExtra(IntentData.KEY_MRZ_INFO, mrzInfo)
                startActivity(intent)
            }
        }

//        Snackbar.make(
//            findViewById(R.id.constraintlayout),
//           "passport Dob = " + passportDob + " passport exipry =" + passportDoe ,
//            100000
//        ).show()


        imageView_backbutton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        imageView_addPassport.setOnClickListener {
            val intent = Intent(this, ScanPassportActivity::class.java)
            startActivity(intent)
        }



    }
    }