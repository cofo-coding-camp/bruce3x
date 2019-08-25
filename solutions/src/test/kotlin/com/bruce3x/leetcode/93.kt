@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._93

import org.junit.Assert.assertArrayEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        assertArrayEquals(
            arrayOf("255.255.11.135", "255.255.111.35"),
            solution.restoreIpAddresses("25525511135").toTypedArray()
        )
        println("---")
        assertArrayEquals(
            arrayOf("0.10.0.10", "0.100.1.0"),
            solution.restoreIpAddresses("010010").toTypedArray()
        )
    }
}