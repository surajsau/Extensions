package com.halfplatepoha.extensions

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View

inline fun SpannableString.colorSpan(on: String, color: Int): SpannableString {
    val colorSpan = ForegroundColorSpan(color)
    val colorSpanStart = indexOf(on)
    setSpan(colorSpan, colorSpanStart, colorSpanStart + on.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

    return this
}

inline fun SpannableString.boldSpan(on: String): SpannableString {
    val styleSpan = StyleSpan(Typeface.BOLD)
    val boldPartStart = indexOf(on)
    setSpan(styleSpan, boldPartStart, boldPartStart + on.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

    return this
}

inline fun SpannableString.clickSpan(on: String, crossinline onClick: (view: View) -> Unit): SpannableString {
    val clickableSpan = object: ClickableSpan() {
        override fun onClick(view: View) {
            onClick.invoke(view)
        }
    }

    val clickablePartStart = indexOf(on)
    setSpan(clickableSpan, clickablePartStart, clickablePartStart + on.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

    return this
}

inline fun SpannableStringBuilder.colorSpan(on: String, color: Int): SpannableStringBuilder {
    val colorSpan = ForegroundColorSpan(color)
    val colorSpanStart = indexOf(on)
    setSpan(colorSpan, colorSpanStart, colorSpanStart + on.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

    return this
}

inline fun SpannableStringBuilder.boldSpan(on: String): SpannableStringBuilder {
    val styleSpan = StyleSpan(Typeface.BOLD)
    val boldPartStart = indexOf(on)
    setSpan(styleSpan, boldPartStart, boldPartStart + on.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

    return this
}

inline fun SpannableStringBuilder.clickSpan(on: String, crossinline onClick: (view: View) -> Unit): SpannableStringBuilder {
    val clickableSpan = object: ClickableSpan() {
        override fun onClick(view: View) {
            onClick.invoke(view)
        }
    }

    val clickablePartStart = indexOf(on)
    setSpan(clickableSpan, clickablePartStart, clickablePartStart + on.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

    return this
}