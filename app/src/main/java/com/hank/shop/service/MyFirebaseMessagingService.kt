package com.hank.shop.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class MyFirebaseMessagingService : FirebaseMessagingService() {
    private val TAG = MyFirebaseMessagingService::class.java.simpleName

    override fun onNewToken(token: String) {
        Log.d(TAG, "onNewToken: $token");
    }
}