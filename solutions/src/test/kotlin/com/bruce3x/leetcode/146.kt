@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._146

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        with(LRUCache(2)) {
            put(1, 1)
            put(2, 2)
            assertEquals(1, get(1))
            put(3, 3)
            assertEquals(-1, get(2))
            put(4, 4)
            assertEquals(-1, get(1))
            assertEquals(3, get(3))
            assertEquals(4, get(4))
        }

        with(LRUCache(2)) {
            assertEquals(-1, get(2))
            put(2, 6)
            assertEquals(-1, get(1))
            put(1, 5)
            put(1, 2)
            assertEquals(2, get(1))
            assertEquals(6, get(2))
        }
    }
}