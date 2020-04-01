package com.halfplatepoha.extensions

import android.app.Activity
import android.content.Context
import android.util.TypedValue
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

inline fun Int.dpToPx(context: Context)
        = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, toFloat(), context.resources.displayMetrics).toInt()

inline fun Float.pxToDp(context: Context) = this / context.resources.displayMetrics.density