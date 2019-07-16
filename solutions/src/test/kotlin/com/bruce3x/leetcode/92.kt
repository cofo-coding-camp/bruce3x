@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._92

import com.bruce3x.leetcode.ListNode
import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {


    @Test
    fun reverseBetween() {
        val solution = Solution()

        println(solution.reverseBetween(ListNode.create(1, 2, 3, 4, 5, 6), 2, 4))
        assertEquals(
            ListNode.create(1, 4, 3, 2, 5, 6),
            solution.reverseBetween(ListNode.create(1, 2, 3, 4, 5, 6), 2, 4)
        )

        assertEquals(
            ListNode.create(6, 5, 4, 3, 2, 1),
            solution.reverseBetween(ListNode.create(1, 2, 3, 4, 5, 6), 1, 6)
        )

        assertEquals(
            null,
            solution.reverseBetween(null, 4, 2)
        )

    }

}