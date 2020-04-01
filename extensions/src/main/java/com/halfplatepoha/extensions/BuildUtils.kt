package com.halfplatepoha.extensions

import android.os.Build

inline fun fromApi(fromVersion: Int, inclusive: Boolean = true, block: () -> Unit) {
    if(Build.VERSION.SDK_INT > fromVersion || (inclusive && Build.VERSION.SDK_INT == fromVersion)) block()
}

inline fun toApi(toVersion: Int, inclusive: Boolean = true, block: () -> Unit) {
    if(Build.VERSION.SDK_INT < toVersion || (inclusive && Build.VERSION.SDK_INT == toVersion)) block()
}

inline fun doFromSdk(version: Int, `if`: () -> Unit, `else`: () -> Unit) {
    if(Build.VERSION.SDK_INT >= version) {
        `if`()
    } else {
        `else`()
    }
}

inline fun doFromSdk(version: Int, `if`: () -> Unit) {
    if(Build.VERSION.SDK_INT >= version) {
        `if`()
    }
}

inline fun doIfSdk(version: Int, `if`: () -> Unit, `else`: () -> Unit) {
    if(Build.VERSION.SDK_INT == version) {
        `if`()
    } else {
        `else`()
    }
}

inline fun doIfSdk(version: Int, `if`: () -> Unit) {
    if(Build.VERSION.SDK_INT >= version) {
        `if`()
    }
}