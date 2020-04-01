package com.halfplatepoha.extensions

import android.app.ActivityManager
import android.app.NotificationManager
import android.app.job.JobScheduler
import android.content.Context
import android.graphics.Point
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat

inline fun Context.getNotificationManager() = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

inline fun Context.getConnectivityManager() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

inline fun Context.getJobScheduler() = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler?

inline fun Context.getWindowManager() = getSystemService(Context.WINDOW_SERVICE) as WindowManager

inline fun Context.getActivityManager() = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager?

inline fun Context.getInputMethodManager() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

inline fun Context.color(@ColorRes colorId: Int) = ContextCompat.getColor(this, colorId)

inline fun Context.drawable(@DrawableRes drawableId: Int) = ContextCompat.getDrawable(this, drawableId)

inline fun Context.inflate(@LayoutRes res: Int, parent: ViewGroup, attachView: Boolean = false) = LayoutInflater.from(this).inflate(res, parent, attachView)

inline val Context.screenDimension: ScreenDimension
    get() {
        val point = getDisplaySize()
        return ScreenDimension(
            height = point.y,
            width = point.x
        )
    }

inline fun Context.getDisplaySize(): Point {
    val display = getWindowManager().defaultDisplay
    val size = Point()
    display.getSize(size)

    return size
}

data class ScreenDimension(val height: Int, val width: Int)