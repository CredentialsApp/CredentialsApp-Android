package com.gatepay.trustid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jmrtd.lds.icao.MRZInfo

class CameraActivity  : AppCompatActivity() , CameraMrzFragment.CameraMLKitCallback {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, CameraMrzFragment())
            .commit()
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

    override fun onPassportRead(mrzInfo: MRZInfo) {
//        val intent = Intent()
//        intent.putExtra("KEY_MRZ_INFO", mrzInfo)
//        setResult(Activity.RESULT_OK, intent)
//        finish()
    }

    override fun onError() {
        onBackPressed()
    }

}