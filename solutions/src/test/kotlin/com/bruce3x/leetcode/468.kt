@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._468

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertEquals("IPv4", solution.validIPAddress("172.16.254.1"))
        assertEquals("IPv6", solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"))
        assertEquals("Neither", solution.validIPAddress("256.256.256.256"))
        assertEquals("Neither", solution.validIPAddress("0.0.0.-0"))
    }
}