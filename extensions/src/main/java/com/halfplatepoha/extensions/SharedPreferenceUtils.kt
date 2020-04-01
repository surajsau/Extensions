package com.halfplatepoha.extensions

import android.content.SharedPreferences

inline fun SharedPreferences.edit(changes: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.changes()
    editor.apply()
}