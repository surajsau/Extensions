package com.halfplatepoha.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast

inline fun<A: Activity> A.onUiThread(crossinline block: A.() -> Unit) {
    if(!isFinishing) {
        runOnUiThread {
            block()
        }
    }
}

inline fun<A: Activity> A.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

inline fun<reified T: Any> Activity.launchActivity(
    requestCode: Int = -1,
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}) {

    val intent = newIntent<T>(this)
    intent.init()

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        startActivityForResult(intent, requestCode, options)
    } else {
        startActivityForResult(intent, requestCode)
    }

}

inline fun<reified T: Any> Activity.launchActivity(
    options: Bundle? = null,
    noinline init: Intent.() -> Unit) {

    val intent = newIntent<T>(this)
    intent.init()

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        startActivity(intent, options)
    } else {
        startActivity(intent)
    }
}

inline fun<reified T: Any> newIntent(context: Context): Intent = Intent(context, T::class.java)