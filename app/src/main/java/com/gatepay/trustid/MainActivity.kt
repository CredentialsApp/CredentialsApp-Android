package com.gatepay.trustid

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_my_crendentials.*


class MainActivity : AppCompatActivity(), BottomSheetEx.BottomSheetListener, AuthBottomSheetEx.authBottomSheetListener {



    private lateinit var sheetBehavior: BottomSheetBehavior<LinearLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_crendentials)

        add_credentials_button.setOnClickListener {
                    val bottomSheet = BottomSheetEx()
                    bottomSheet.show(supportFragmentManager, "BottomSheetEx")
                }



        Firebase.dynamicLinks
            .getDynamicLink(intent)
            .addOnSuccessListener(this) { pendingDynamicLinkData ->
                // Get deep link from result (may be null if no link is found)
                var deepLink: Uri? = null
                if (pendingDynamicLinkData != null) {
                    deepLink = pendingDynamicLinkData.link

                    val deepLinkHexString =
                        removeWord(deepLink.toString(), "https://trust-id.co/resolve/")
                    val asciiStringDeepLink = HexadecimalToASCII(deepLinkHexString)
                    val completeUri = Uri.parse("https://trust-id.co/resolve" + asciiStringDeepLink)
                    var scope: String = completeUri.getQueryParameter("scope").toString()
                    val license_key : String = completeUri.getQueryParameter("license_key").toString()
                    val splitScopeArray = scope.split(",").toTypedArray()
                        splitScopeArray.forEach { println(it) }


                    //TODO deactivate dismissing of bottom sheet



                    if (license_key == "76a13-4ca79-637a2-8df2c") {
                        val authBottomSheet = AuthBottomSheetEx()
                        authBottomSheet.show(supportFragmentManager, "Auth BottomSheetEx")

                    }
                    else {
                        scope = " License key not valid"
                    }



                    Snackbar.make(
                        findViewById(R.id.constraintlayout),
                        scope,
                        100000
                    ).show()

                    val toast = Toast.makeText(
                        applicationContext,
                        scope,
                        Toast.LENGTH_LONG
                    )
                    toast.show()
                }


               //TODO ADD ERROR CASE HERE
            }
            .addOnFailureListener(this) { e -> Log.w("TAG", "getDynamicLink:onFailure", e) }
    }



    override fun onOptionClick(text: String) {
        TODO("Not yet implemented")
    }




    fun removeWord(value: String, word: String): String {
        var result = ""
        var possibleMatch = ""
        var i = 0
        var j = 0

        while ( i in 0 until value.length ) {
            if ( value[i] == word[j] ) {
                if ( j == word.length - 1 ) { // match
                    possibleMatch = "" // discard word
                    j = 0
                }
                else {
                    possibleMatch += value[i]
                    j++
                }
            }
            else {
                result += possibleMatch
                possibleMatch = ""
                if ( j == 0 ) {
                    result += value[i]
                }
                else {
                    j = 0
                    i-- // re-test
                }
            }
            i++
        }
        return result
    }


    fun HexadecimalToASCII(hexValue: String): String {

        // TODO CHECK IF STRING MATCHES HEXADECIMAL
        var asciiString = ""
            var i = 0
            while (i < hexValue.length) {

                val part: String = hexValue.substring(i, i + 2)
                val asciiChar = part.toInt(16).toChar()
                asciiString = asciiString + asciiChar
                i += 2
            }
        return asciiString
    }



}