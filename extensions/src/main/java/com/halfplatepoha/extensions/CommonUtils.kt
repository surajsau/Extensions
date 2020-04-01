package com.halfplatepoha.extensions

import java.lang.Exception

inline fun Int.toBoolean() = this > 0

inline fun Boolean.toInt() = if(this) 1 else 0

inline fun tryOrIgnore(block: () -> Unit) {
    try {
        block()
    } catch (e: Exception) {}
}