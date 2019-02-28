package com.tomtre.android.architecture.shoppinglistmvp.util

import java.lang.IllegalArgumentException

object CommonUtils {
    fun leftSubString(str: String, len: Int): String {
        if (len < 0) {
            throw IllegalArgumentException("len is less then 0")
        }
        return if (str.length <= len) {
            str
        } else {
            str.substring(0, len)
        }
    }
}