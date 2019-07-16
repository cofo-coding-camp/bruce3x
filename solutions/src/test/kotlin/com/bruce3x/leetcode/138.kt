@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._138

import org.junit.Assert.*
import org.junit.Test


class SolutionTest {
    @Test
    fun copyRandomList() {
        val solution = Solution()

        val node1 = Node().apply { value = 1 }
        val node2 = Node().apply { value = 2 }
        node1.next = node2
        node2.next = null
        node1.random = node2
        node2.random = node2

        val copied = solution.copyRandomList(node1)

        assertEquals(1, copied?.value)
        assertNotSame(node1, copied)
        assertEquals(2, copied?.next?.value)
        assertNotSame(node2, copied)

        assertEquals(2, copied?.random?.value)
        assertEquals(2, copied?.next?.random?.value)

        assertEquals(5, solution.copyRandomList(Node().apply { value = 5 })?.value)
        assertNull(solution.copyRandomList(null))
    }
}