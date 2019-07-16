/**
 * [225] Implement Stack using Queues
 *
 * https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 *
 * Implement the following operations of a stack using queues.
 *
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 *
 *
 * Example:
 *
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top(); // returns 2
 * stack.pop(); // returns 2
 * stack.empty(); // returns false
 *
 * Notes:
 *
 *
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 *
 *
 *
 * Difficulty:     Easy
 * TestCase:       ["MyStack","push","push","top","pop","empty"], [[],[1],[2],[],[],[]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._225

import java.util.*

class MyStack {

    /** Initialize your data structure here. */
    private var q1: Queue<Int> = LinkedList<Int>()
    private var q2: Queue<Int> = LinkedList<Int>()

    /** Push element x onto stack. */
    fun push(x: Int) {
        q2.offer(x)
        while (!q1.isEmpty()) {
            q2.offer(q1.poll())
        }

        val tmp = q1
        q1 = q2
        q2 = tmp
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int = q1.poll()

    /** Get the top element. */
    fun top(): Int =q1.peek()

    /** Returns whether the stack is empty. */
    fun empty(): Boolean = q1.isEmpty()

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */