package com.example.realtime

import android.content.Intent
import android.net.Uri
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFireBaseService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        remoteMessage?.data?.isNotEmpty()?.let {
            Log.d("Message", remoteMessage.data.toString())
        }

        remoteMessage?.notification?.let {
            Log.d("NotifyMessage", "Message Notification Body: ${it.body}")
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.setDataAndType(
                    Uri.parse(remoteMessage.notification?.body.toString()),
                    "video/mp4"
                )
                startActivity(intent)
            } catch (err: Exception) {
                Log.e("ERROR", err.message)
            }
        }
    }
}