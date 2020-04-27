package com.gatepay.trustid

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.LinearLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_my_crendentials.*


class MainActivity : AppCompatActivity(), BottomSheetEx.BottomSheetListener {



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
                    var deepLinkHexString =
                        removeWord(deepLink.toString(), "https://trust-id.co/resolve/")
                    Snackbar.make(
                        findViewById(R.id.constraintlayout),
                        deepLinkHexString,
                        Snackbar.LENGTH_LONG
                    ).show()
                }

                // Handle the deep link. For example, open the linked
                // content, or apply promotional credit to the user's
                // account.
                // ...

                // ...
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

}