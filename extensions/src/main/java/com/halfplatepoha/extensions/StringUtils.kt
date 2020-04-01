package com.halfplatepoha.extensions

import android.graphics.Color
import android.util.Patterns
import androidx.annotation.ColorInt
import java.net.URLDecoder
import java.net.URLEncoder

inline fun String.urlencode() = encodeToUrl()

inline fun String.urldecode() = decodeToUrl()

inline fun String.encodeToUrl(charSet: String = "UTF-8") = URLEncoder.encode(this, charSet)

inline fun String.decodeToUrl(charSet: String = "UTF-8") = URLDecoder.decode(this, charSet)

inline fun String?.isValidEmail(): Boolean = this.isNullOrEmpty() || Patterns.EMAIL_ADDRESS.matcher(this).matches()

inline fun join(vararg params: Any?) = params.joinToString(" ")

inline fun joinWith(separator: String = " ", vararg params: Any?) = params.joinToString(separator = separator)

inline val String.asColor: Int @ColorInt
    get() = Color.parseColor(this)

/**
 * If the string is a HTTP URL (ie. Starts with http:// or https://)
 */
fun String.isHttp(): Boolean {
    return this.matches(Regex("(http|https)://[^\\s]*"))
}