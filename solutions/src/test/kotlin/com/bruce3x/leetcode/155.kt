@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._155

import org.junit.Assert.assertEquals
import org.junit.Test

class MinStackTest {

    @Test
    fun test() {
        val s = MinStack()
        s.push(-2)
        s.push(0)
        s.push(-3)
        assertEquals(-3, s.getMin())
        s.pop()
        assertEquals(0, s.top())
        assertEquals(-2, s.getMin())
    }
}