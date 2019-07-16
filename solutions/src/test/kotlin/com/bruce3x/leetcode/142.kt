@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._142

import com.bruce3x.leetcode.ListNode
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test


class SolutionTest {
    @Test
    fun detectCycle() {
        val s = Solution()


        val nodes = listOf(
            ListNode(3),
            ListNode(2),
            ListNode(0),
            ListNode(4)
        )
        nodes.forEachIndexed { index, node ->
            node.next = nodes.getOrNull(index + 1)
        }
        nodes[3].next = nodes[1]

        assertTrue(nodes[1] === s.detectCycle(nodes[0]))

        val node1 = ListNode(1)
        val node2 = ListNode(2)
        node1.next = node2
        node2.next = node1
        assertTrue(node1 === s.detectCycle(node1))

        assertNull(s.detectCycle(ListNode.create(1, 2, 3)))

        assertNull(s.detectCycle(null))
    }
}