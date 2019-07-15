@file:Suppress("EqualsOrHashCode")

package com.bruce3x.leetcode


class ListNode(var value: Int) {
    var next: ListNode? = null

    companion object {
        fun create(vararg values: Int): ListNode {
            val head = ListNode(values[0])
            var tail = head
            var index = 1
            while (index < values.size) {
                val node = ListNode(values[index])
                tail.next = node
                tail = node
                index++
            }

            return head
        }
    }

    override fun toString(): String {
        val values = mutableListOf<Any>()
        var node: ListNode? = this
        while (node != null) {
            values.add(node.value)
            node = node.next
        }
        values.add("null")
        return "ListNodes: ${values.joinToString(separator = " -> ")}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ListNode) return false

        return if (this.value == other.value) {
            this.next == other.next
        } else {
            false
        }
    }
}