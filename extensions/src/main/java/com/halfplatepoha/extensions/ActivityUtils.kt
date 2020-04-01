package com.halfplatepoha.extensions

import android.app.Activity
import android.widget.Toast

inline fun<A: Activity> A.onUiThread(crossinline block: A.() -> Unit) {
    if(!isFinishing) {
        runOnUiThread {
            block()
        }
    }
}

inline fun<A: Activity> A.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()