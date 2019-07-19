@file:Suppress("EqualsOrHashCode")

package com.bruce3x.leetcode

import java.util.*

class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun equals(other: Any?): Boolean {
        if (other !is TreeNode) return false
        return this.value == other.value && this.left == other.left && this.right == other.right
    }

    override fun toString(): String {
        val queue: Queue<TreeNode?> = LinkedList()
        val nodes = mutableListOf<TreeNode?>()
        queue.add(this)
        while (queue.isNotEmpty()) {
            val node = queue.remove()
            nodes.add(node)

            node?.takeUnless { it.left == null && it.right == null }?.run {
                queue.add(left)
                queue.add(right)
            }
        }

        return "[" + nodes.joinToString { it?.value.toString() } + "]"
    }

    companion object {
        fun create(vararg values: Int?): TreeNode {
            val rootValue = values.firstOrNull() ?: throw IllegalArgumentException("invalid tree")
            val root = TreeNode(rootValue)
            val queue: Queue<TreeNode> = LinkedList()
            queue.add(root)
            var index = 1
            while (queue.isNotEmpty()) {
                val node = queue.remove()

                node.left = values.getOrNull(index++)?.let { TreeNode((it)) }?.also { queue.add(it) }
                node.right = values.getOrNull(index++)?.let { TreeNode((it)) }?.also { queue.add(it) }
            }

            return root
        }
    }
}