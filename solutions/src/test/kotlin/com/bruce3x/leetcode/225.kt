@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._225

import org.junit.Assert.*
import org.junit.Test


class MyStackTest {
    @Test
    fun test() {
        val s = MyStack()
        s.push(1)
        s.push(2)
        assertEquals(2, s.top())
        assertEquals(2, s.pop())
        assertFalse(s.empty())
        assertEquals(1, s.pop())
        assertTrue(s.empty())
    }
}