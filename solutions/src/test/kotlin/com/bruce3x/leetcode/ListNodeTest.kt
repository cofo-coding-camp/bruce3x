package com.bruce3x.leetcode

import org.junit.Assert.*
import org.junit.Test

class ListNodeTest {

    @Test
    fun testToString() {
        val head = ListNode.create(5, 3, 4, 2, 1)
        assertEquals("ListNodes: 5 -> 3 -> 4 -> 2 -> 1 -> null", head.toString())

        assertEquals("ListNodes: 1 -> null", ListNode(1).toString())
    }

    @Test
    fun testCreate() {
        val head = ListNode.create(5, 3, 4, 2, 1)
        var node: ListNode? = head
        assertEquals(5, node?.value)

        node = node?.next
        assertEquals(3, node?.value)

        node = node?.next
        assertEquals(4, node?.value)

        node = node?.next
        assertEquals(2, node?.value)

        node = node?.next
        assertEquals(1, node?.value)

        node = node?.next
        assertEquals(null, node?.value)
    }

    @Test
    fun testEquals() {
        val node1 = ListNode.create(5, 3, 4, 2, 1)
        val node2 = ListNode.create(5, 3, 4, 2, 1)
        val node3 = ListNode.create(5, 9, 4, 2, 1)
        val node4 = ListNode.create(5, 3, 4, 2, 1, 0)

        assertTrue(node1 == node2)
        assertFalse(node1 == node3)
        assertFalse(node1 == node4)
    }
}