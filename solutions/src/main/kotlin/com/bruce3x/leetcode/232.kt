/**
 * [232] Implement Queue using Stacks
 *
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 *
 * Implement the following operations of a queue using stacks.
 *
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 *
 *
 * Example:
 *
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek(); // returns 1
 * queue.pop(); // returns 1
 * queue.empty(); // returns false
 *
 * Notes:
 *
 *
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 *
 *
 *
 * Difficulty:     Easy
 * TestCase:       ["MyQueue","push","push","peek","pop","empty"], [[],[1],[2],[],[],[]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._232

import java.util.*

class MyQueue() {

    /** Initialize your data structure here. */
    private val s1 = Stack<Int>()
    private val s2 = Stack<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        while (!s2.isEmpty()) {
            s1.push(s2.pop())
        }
        s1.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        while (!s1.isEmpty()) {
            s2.push(s1.pop())
        }
        return s2.pop()
    }

    /** Get the front element. */
    fun peek(): Int {
        while (!s1.isEmpty()) {
            s2.push(s1.pop())
        }
        return s2.peek()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean = s1.isEmpty() && s2.isEmpty()

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */