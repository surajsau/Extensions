package com.halfplatepoha.extensions

import java.util.*

inline val Date.calendar: Calendar
    get() {
        val calendar = Calendar.getInstance()
        calendar.time = this
        return calendar
    }

inline fun Date.tomorrow(): Date {
    val timestamp = this.toMillis()+ 1.day
    return Date(timestamp)
}

inline fun Date.dayAfterTomorrow(): Date {
    val timestamp = this.toMillis() + 2.day
    return Date(timestamp)
}

inline fun Date.isSameDay(date: Date): Boolean {
    val calendar1 = this.calendar
    val calendar2 = date.calendar

    val day1 = calendar1.get(Calendar.DAY_OF_YEAR)

    val day2 = calendar2.get(Calendar.DAY_OF_YEAR)

    return day1 == day2
}

inline fun Date.toMillis() = this.calendar.timeInMillis