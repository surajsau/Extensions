package com.halfplatepoha.sample

import com.halfplatepoha.extensions.REGEX_TEXT_FORMATTING
import org.junit.Test

import org.junit.Assert.*
import java.util.regex.Pattern

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_regex() {
        /*
            bc = bold color
            bcn = bold color name
            bct = bold color text
            c = color
            cn = color name
            ct = color text
            b = bold
            bt = bold text
         */
        val string = "Sample text <*>to test</> wh <color sample-color>detection works</> or not in <*color sample-color>this</> case. Let <*color sample-2>us have</> another test."
//        val pattern = Pattern.compile("(?<bc><\\*color (?<bcn>.*?)>(?<bct>.*?)<\\/>)|(?<c><color (?<cn>.*?)>(?<ct>.*?)<\\/>)|(?<b><\\*>(?<bt>.*?)<\\/>)")
        val pattern = Pattern.compile(REGEX_TEXT_FORMATTING)

        val matches = pattern.matcher(string)

        while(matches.find()) {
            for(i in 0..matches.groupCount()) {
                println("$i: ${matches.group(i)}")
            }
            println("--------")
            if(!matches.group("bold").isNullOrEmpty()) {
                println("bold")
            }

            if(!matches.group("color").isNullOrEmpty()) {
                println("color")
            }

            if(!matches.group("cn").isNullOrEmpty()) {
                println("cn: ${matches.group("cn")}")
            }

            if(!matches.group("ct").isNullOrEmpty()) {
                println("ct: ${matches.group("ct")}")
            }
            println("--------")
        }

//        while(matches.find()) {
//            if(!matches.group("bc").isNullOrEmpty()) {
//                val match = matches.group("bc")
//                println("bc: $match")
//
//                val x = boldColorPattern.matcher(match)
//
//            } else if(!matches.group("c").isNullOrEmpty()) {
//                val match = matches.group("c")
//                println("c: $match")
//
//                val result = colorTextPattern.matcher(match)
//                while(result.find()) {
//                    println("ct: ${result.group("ct")}")
//                }
//            } else if(!matches.group("b").isNullOrEmpty()) {
//                val match = matches.group("b")
//                println("b: $match")
//                val x = boldPattern.matcher(match)
//
//                while(x.find()) {
//                    if(!x.group("bt").isNullOrEmpty()) {
//                        println("bt: ${x.group("bt")}")
//                    }
//                }
//            }
//        }
    }
}
