package com.halfplatepoha.extensions

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.IdRes

inline fun <ET: EditText> ET.getTextString(): String? {
    if(this.text != null)
        return this.text.toString()
    return null
}

inline val <ET: EditText> ET.isEmpty: Boolean
    get() = this.getTextString().isNullOrEmpty()

inline fun Activity.textView(@IdRes id: Int): TextView = findViewById(id)

inline fun <TV: TextView> TV.format(colorMap: Map<String, Int?>) {
    val spannedString = text.toString().format(colorMap)
    text = spannedString
}

inline val Int.dp: Int get() = (this / Resources.getSystem().displayMetrics.density).toInt()

inline val Int.px: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()

inline fun View?.dismissKeyboard() = this?.let {
    it.context.getInputMethodManager().hideSoftInputFromWindow(it.windowToken, 0)
}