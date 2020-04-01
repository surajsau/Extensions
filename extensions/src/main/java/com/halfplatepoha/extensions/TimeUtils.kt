package com.halfplatepoha.extensions

import java.text.SimpleDateFormat
import java.util.*

fun now(): Long = System.currentTimeMillis()

fun tomorrow(): Long = now() + 1.day

val FIVE_MIN = 5.minute
val ONE_WEEK = 7.day
val ONE_MONTH = 30.day
val ONE_YEAR = 365.day

const val DD_MMM_YYYY = "dd MMM yyyy"
const val DD_MMM_HH_MM = "dd MMM HH:mm"

inline val Int.day: Long
    get() = this * 86400_000L

inline val Int.hour: Long
    get() = this * 3600_000L

inline val Int.minute: Long
    get() = this * 60_000L

inline val Int.second: Long
    get() = this * 1_000L

inline fun Long.formattedString(format: String): String {
    return SimpleDateFormat(format, Locale.getDefault()).format(Date(this))
}

/**
 * Returns time elapsed string for a given timestamp
 * from referenceTime
 *
 * @param referenceTime Time reference based on which ' ago' string is
 *                      generated. Default value is current time
 */
inline fun Long.timeAgo(referenceTime: Long = now()):String {
    val diff = referenceTime - this

    return when {
        diff >= 2 * ONE_MONTH -> /* on ... */"on ${referenceTime.formattedString(
            DD_MMM_YYYY
        )}"
        diff >= ONE_MONTH -> /* last month */"last month"
        diff >= 2 * ONE_WEEK -> /* 7 weeks ago */ "${diff / ONE_WEEK} weeks ago"
        diff >= ONE_WEEK -> /* last week */ "last week"
        diff >= 2.day -> /* 29 days ago */ "${diff / 1.day} days ago"
        diff >= 1.day -> /* yesterday */ "yesterday"
        diff >= 2.hour -> /* 23 hours ago */ "${diff / 1.hour} hours ago"
        diff >= 1.hour -> /* an hour ago */ "an hour ago"
        diff >= 2.minute -> /* 5 minutes ago */ "${diff / 1.minute} minutes ago"
        diff >= 1.minute -> /* a minute ago */ return "a minute ago"
        else -> "just now"
    }

}