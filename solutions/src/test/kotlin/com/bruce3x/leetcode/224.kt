@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._224

import org.junit.Assert.*
import org.junit.Test


class SolutionTest{
    @Test
    fun calculate(){
        val solution = Solution()

        assertEquals(2, solution.calculate("1 + 1"))
        assertEquals(3, solution.calculate("2-1 + 2"))
        assertEquals(23, solution.calculate("(1+(4+5+2)-3)+(6+8)"))
    }
}