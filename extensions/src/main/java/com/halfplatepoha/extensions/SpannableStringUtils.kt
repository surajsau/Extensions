package com.halfplatepoha.extensions

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import android.view.View
import java.lang.Exception
import java.util.regex.Pattern

/**
 * Formats the string to a SpannableStringBuilder. The syntax rules for formatting a string:
 * [1] <*>..</> to make text bold
 * [2] <color color-name></> for setting color to text
 * [3] <*color color-name></> for setting color and making text bold
 *
 * @param colorMap Map of 'color name' in the String to Color Int resource. Each color name has to mapped
 *          to a Color Int resource else it'll throw an Exception
 *
 * @throws Exception when there are missing mappings in colorMap
 */
@SuppressLint("NewApi")
inline fun String.format(colorMap: Map<String, Int?>): SpannableStringBuilder {
    val spannableString = SpannableStringBuilder(this)
    val pattern = Pattern.compile(REGEX_TEXT_FORMATTING)

    val matcher = pattern.matcher(this)

    while(matcher.find()) {
        val match = matcher.group(0)

        val bold = matcher.group(1)
        val color = matcher.group(2)
        val colorName = matcher.group(3)
        val colorText = matcher.group(4)

        if(!bold.isNullOrEmpty()) {
            spannableString.boldSpan(match)
        }

        if(!colorName.isNullOrEmpty()) {
            val color: Int = colorMap[colorName] ?: throw Exception("entry corresponding to $colorName is missing in map")
            spannableString.colorSpan(match, color)
        }

        val start = spannableString.indexOf(match)
        val end = start + match.length

        spannableString.replace(start, end, colorText)
    }

    return spannableString
}

inline fun<Span: Spannable> Span.colorSpan(on: String, color: Int) {
    val colorSpan = ForegroundColorSpan(color)
    val start = indexOf(on)
    setSpan(colorSpan, start, start + on.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
}

inline fun<Span: Spannable> Span.boldSpan(on: String) {
    val styleSpan = StyleSpan(Typeface.BOLD)
    val start = indexOf(on)
    setSpan(styleSpan, start, start + on.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
}

inline fun<Span: Spannable> Span.strikeThroughSpan(on: String) {
    val start = indexOf(on)
    setSpan(StrikethroughSpan(), start, start + on.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
}

inline fun<Span: Spannable> Span.clickSpan(on: String, crossinline onClick: (view: View) -> Unit) {
    val clickableSpan = object: ClickableSpan() {
        override fun onClick(view: View) {
            onClick.invoke(view)
        }
    }

    val start = indexOf(on)
    setSpan(clickableSpan, start, start + on.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
}