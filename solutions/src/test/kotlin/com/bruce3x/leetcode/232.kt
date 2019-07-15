@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._232

import org.junit.Assert.*
import org.junit.Test


class MyQueueTest {
    @Test
    fun test() {
        val q = MyQueue()
        q.push(1)
        q.push(2)
        assertEquals(1, q.peek())
        assertEquals(1, q.pop())
        assertFalse(q.empty())
        assertEquals(2, q.pop())
        assertTrue(q.empty())
    }
}