package com.gatepay.trustid


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


import kotlinx.android.synthetic.main.activity_add_passport.*




class addPassport : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_passport)

        val passportDocumentNo = intent.getStringExtra("KEY_MRZ_INFO_DOC_NO")
        val passportDob = intent.getStringExtra("KEY_MRZ_INFO_DOC_NO")
        val passportDoe =intent.getStringExtra("KEY_MRZ_INFO_DOC_NO")


        if (passportDocumentNo != null){
            imageView_addPassport.isEnabled = false
            imageView_addPassport.setImageResource(R.drawable.scan_passport_done_btn)



            imageView_addNFC.setOnClickListener {
                val intent = Intent(this, NfcPassport::class.java)
                intent.putExtra("PassportDocNo", passportDocumentNo)
                intent.putExtra("PassportDob", passportDob)
                intent.putExtra("PassportDoe", passportDoe)
                startActivity(intent)
            }
        }

        Snackbar.make(
            findViewById(R.id.constraintlayout),
           "passport number = " + passportDocumentNo,
            1000
        ).show()


        imageView_backbutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        imageView_addPassport.setOnClickListener {
            val intent = Intent(this, ScanPassport::class.java)
            startActivity(intent)
        }



    }
    }