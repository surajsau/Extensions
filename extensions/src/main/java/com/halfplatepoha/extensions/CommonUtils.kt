package com.halfplatepoha.extensions

import android.os.Build

fun Int.toBoolean() = this > 0

fun Boolean.toInt() = if(this) 1 else 0

fun MatchGroup?.isNotNull() = this != null

var IS_OREO = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O