@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._784

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()
        solution.letterCasePermutation("a1b2").let { results ->
            assertEquals(4, results.size)
            assertTrue("a1b2" in results)
            assertTrue("a1B2" in results)
            assertTrue("A1b2" in results)
            assertTrue("A1B2" in results)
        }

        solution.letterCasePermutation("3z4").let {
            assertEquals(2, it.size)
            assertTrue("3z4" in it)
            assertTrue("3Z4" in it)
        }

        solution.letterCasePermutation("12345").let {
            assertEquals(1, it.size)
            assertTrue("12345" in it)
        }
    }
}