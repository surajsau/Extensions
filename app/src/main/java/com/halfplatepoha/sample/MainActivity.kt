package com.halfplatepoha.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.halfplatepoha.extensions.color
import com.halfplatepoha.extensions.textView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val string = "Sample text wh <color sample-color>detection works</> or not in <*color sample-color>this</> case. Let <*color sample-2>us have</> another test."
        val map = HashMap<String, Int>().apply {
            put("sample-color", color(R.color.colorAccent))
            put("sample-2", color(R.color.colorPrimaryDark))
        }

        textView(R.id.tv).text = string.format(map)
    }
}
