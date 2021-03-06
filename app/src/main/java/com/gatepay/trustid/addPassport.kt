package com.gatepay.trustid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


import kotlinx.android.synthetic.main.activity_add_passport.*

class addPassport : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_passport)

        imageView_backbutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        imageView_addPassport.setOnClickListener {
            val intent = Intent(this, ScanPassport::class.java)
            startActivity(intent)
        }


        imageView_addNFC.setOnClickListener {
            val intent = Intent(this, NfcPassport::class.java)
            startActivity(intent)
        }
    }
    }