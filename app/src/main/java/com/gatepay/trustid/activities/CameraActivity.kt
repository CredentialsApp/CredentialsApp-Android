package com.gatepay.trustid.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gatepay.trustid.CameraMrzFragment
import com.gatepay.trustid.R
import org.jmrtd.lds.icao.MRZInfo

class CameraActivity  : AppCompatActivity() ,
    CameraMrzFragment.CameraMLKitCallback {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                CameraMrzFragment()
            )
            .commit()
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

    override fun onPassportRead(mrzInfo: MRZInfo) {
        val intent = Intent(this, addPassportCredentialActivity::class.java)
        intent.putExtra("KEY_MRZ_INFO_DOC_NO", mrzInfo.documentNumber.toString())
        intent.putExtra("KEY_MRZ_INFO_DOB", mrzInfo.dateOfBirth.toString())
        intent.putExtra("KEY_MRZ_INFO_DOE", mrzInfo.dateOfExpiry.toString())
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    override fun onError() {
        onBackPressed()
    }

}