package io.clearquote.assessment.cq_android_sdk_integration_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.clearquote.assessment.cq_sdk.CQSDKInitializer
import io.clearquote.assessment.cq_sdk.support.Constants.UAT

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Starter code
        CQSDKInitializer(this).initSDK(
            // TODO Add the SDK key given by CQ
            sdkKey = "2ddf63d4-b8be-4f1e-b9b9-17231558e7ce.cquat",

            // TODO Add the Region here
            region = UAT,
            result = { initialized, code, message ->
                if (code == 200){
                    CQSDKInitializer(this).startInspection(
                        activityContext = this,
                        result = { started ->
                        }
                    )
                }
            }
        )

    }
}