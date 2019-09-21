@file:Suppress("EqualsOrHashCode")

package com.bruce3x.leetcode


class ListNode(var value: Int) {
    var next: ListNode? = null

    companion object {
        fun create(vararg values: Int): ListNode? {
            val dummy = ListNode(-1)
            var tail = dummy
            values.forEach {
                val node = ListNode(it)
                tail.next = node
                tail = node
            }
            return dummy.next
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