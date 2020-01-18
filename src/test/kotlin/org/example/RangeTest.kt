package org.example

import org.junit.Test

class RangeTest {
    @Test
    fun new() {
        val a = Range("2019-01-01", "2020-01-01")
        println(a)
    }
}