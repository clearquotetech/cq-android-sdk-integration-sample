package io.clearquote.assessment.cq_android_sdk_integration_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.clearquote.assessment.cq_sdk.CQSDKInitializer
import io.clearquote.assessment.cq_sdk.support.Constants.EU_Region
import io.clearquote.assessment.cq_sdk.support.Constants.UAT

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instantiate the CQSDKInitializer class
        val cqSDKInitializer = CQSDKInitializer(this)

        // Check if SDK is initialized or not if not
        if (cqSDKInitializer.isCQSDKInitialized()){
            // Start the inspection flow
            cqSDKInitializer.startInspection(
                activityContext = this,
                result = { started ->
                    // Handle the response
                }
            )
        }else{
            // Initialize the SDK
            cqSDKInitializer.initSDK(
                // TODO Add the SDK key given by CQ
                token = "<SDK Key>",
                // TODO Add the Region here
                region = UAT,
                result = { initialized, code, message ->
                    if (code == 200){
                        // Start the inspection
                        cqSDKInitializer.startInspection(
                            activityContext = this,
                            result = { started ->
                                // Handle the response
                            }
                        )
                    }
                }
            )
        }
    }
}