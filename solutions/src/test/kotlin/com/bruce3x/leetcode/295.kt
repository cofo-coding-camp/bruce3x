@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._295

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val finder = MedianFinder()
        finder.addNum(1)
        finder.addNum(2)
        assertEquals(1.5, finder.findMedian(), 1e-6)
        finder.addNum(3)
        assertEquals(2.0, finder.findMedian(), 1e-6)
        finder.addNum(0)
        assertEquals(1.5, finder.findMedian(), 1e-6)
    }
}