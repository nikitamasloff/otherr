package com.example.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.annotation.StringRes
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.TaskStackBuilder
import androidx.core.content.getSystemService

private const val PRIMARY_CHANNEL_ID = "primary_channelll"
private const val SECONDARY_CHANNEL_ID = "secondary_channelll"

private const val SIMPLE_NOTIFICATION_ID = 11
private const val EXPANDABLE_NOTIFICATION_ID = 44

class MainActivity : AppCompatActivity() {

    private lateinit var handler: Handler
    private lateinit var notificationBuilder: NotificationCompat.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = Handler()

        createPrimaryNotificationChannel(PRIMARY_CHANNEL_ID)
        createSecondaryNotificationChannel(SECONDARY_CHANNEL_ID)

        postDelayed(5000) {
            createSimpleNotification(PRIMARY_CHANNEL_ID, NotificationCompat.PRIORITY_HIGH)
        }
        postDelayed(15000) {
            createSimpleNotification(SECONDARY_CHANNEL_ID, NotificationCompat.PRIORITY_LOW)
        }
        postDelayed(10000) {
            updateSimpleNotification()
        }
        postDelayed(15000) {
            removeSimpleNotification()
        }

        postDelayed(5000) {
            createExpandableNotification(
                SECONDARY_CHANNEL_ID,
                NotificationManagerCompat.IMPORTANCE_HIGH
            )
        }
    }

    private fun createSimpleNotification(channelId: String, priority: Int) {
        notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_box)
            .setContentTitle(string(R.string.notification_title))
            .setContentText(string(R.string.notification_short_text))
            .setPriority(priority)
            .setContentIntent(anotherOneActivityPendingIntent)
            .setAutoCancel(true)

        notificationManager.notify(SIMPLE_NOTIFICATION_ID, notificationBuilder.build())
    }

    private fun updateSimpleNotification() {
        notificationBuilder.apply {
            setOnlyAlertOnce(true)
            setContentText(string(R.string.notification_long_text))
        }
        notificationManager.notify(SIMPLE_NOTIFICATION_ID, notificationBuilder.build())
    }

    private fun removeSimpleNotification() {
        notificationManager.cancel(SIMPLE_NOTIFICATION_ID)
    }

    private fun createExpandableNotification(channelId: String, priority: Int) {
        notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_box)
            .setContentTitle(string(R.string.notification_title))
            .setContentText(string(R.string.notification_short_text))
            .setPriority(priority)
            .setContentIntent(anotherOneActivityPendingIntent)
            .setAutoCancel(true)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText(string(R.string.notification_long_text))
            )

        notificationManager.notify(EXPANDABLE_NOTIFICATION_ID, notificationBuilder.build())
    }

    private fun configureSecondaryChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val secondaryChannel = notificationManager.getNotificationChannel(SECONDARY_CHANNEL_ID)
            Log.d("mytag", secondaryChannel.description)
        }
    }

    private fun createPrimaryNotificationChannel(id: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = string(R.string.notification_channel_1_name)
            val description = string(R.string.notification_channel_1_description)
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance)
            channel.description = description
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createSecondaryNotificationChannel(id: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = string(R.string.notification_channel_2_name)
            val description = string(R.string.notification_channel_2_description)
            val importance = NotificationManager.IMPORTANCE_LOW
            val channel = NotificationChannel(id, name, importance)
            channel.description = description
            notificationManager.createNotificationChannel(channel)
        }
    }

    private val notificationManager: NotificationManager get() = getSystemService()!!

    private val anotherOneActivityIntent: Intent by lazy {
        Intent(this, AnotherOneActivity::class.java)
    }

    private val anotherOneActivityPendingIntent: PendingIntent by lazy {
        val taskStackBuilder = TaskStackBuilder.create(this)
        taskStackBuilder.addNextIntentWithParentStack(anotherOneActivityIntent)
        taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)!!
    }

    private fun postDelayed(delayMillis: Long, action: () -> Unit) {
        handler.postDelayed(action, delayMillis)
    }

    private fun string(@StringRes stringResId: Int): String = getString(stringResId)
}
