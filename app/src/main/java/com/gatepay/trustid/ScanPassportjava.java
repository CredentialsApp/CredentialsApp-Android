package com.gatepay.trustid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.appliedrec.mrtdreader.BACInputFragment;
import com.appliedrec.mrtdreader.BACSpec;
import com.appliedrec.mrtdreader.MRTDScanActivity;
import com.appliedrec.mrtdreader.MRTDScanResult;

public class ScanPassportjava  extends AppCompatActivity implements BACInputFragment.OnBACInputListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Do other things to set up your activity

        setContentView(R.layout.test_layout);

        Button button;
        button = findViewById(R.id.idbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startScan();
            }
        });



    }

//    String docNumber = "document number"; // Enter the real number
//    Date dateOfBirth = new Date(); // Enter the real date
//    Date dateOfExpiry = new Date(); // Enter the deal date
//    BACSpec bacSpec = new BACSpec(docNumber, dateOfBirth, dateOfExpiry);


//        if (savedInstanceState == null) {
//            // Create BAC input fragment
//            BACInputFragment bacInputFragment = BACInputFragment.newInstance(bacSpec);
//            // Add the fragment to the fragment manager
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .add(R.id.my_fragment_container, bacInputFragment)
//                    .commit();
//        }//   }

    @Override
    public void onBACChanged(BACSpec bacSpec) {
        if (bacSpec != null) {
            // User entered all BAC variables
            // Enable a 'start scan' button or similar
        }
    }


    private void startScan() {
        BACSpec bacSpec; // Obtained in the onBACChanged method of BACInputFragment.OnBACInputListener
        Intent intent = new Intent(this, MRTDScanActivity.class);
        //intent.putExtra(MRTDScanActivity.EXTRA_BAC_SPEC, bacSpec);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null && data.hasExtra(MRTDScanActivity.EXTRA_MRTD_SCAN_RESULT)) {
            // Scan succeeded
            MRTDScanResult scanResult = data.getParcelableExtra(MRTDScanActivity.EXTRA_MRTD_SCAN_RESULT);
        } else if (resultCode == RESULT_OK && data != null && data.hasExtra(MRTDScanActivity.EXTRA_MRTD_SCAN_ERROR)) {
            // Failed to scan the document
            String errorMessage = data.getStringExtra(MRTDScanActivity.EXTRA_MRTD_SCAN_ERROR);
        }
    }
}