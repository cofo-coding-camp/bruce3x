/**
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 *
 *
 *
 * Example:
 *
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); --> Returns -3.
 * minStack.pop();
 * minStack.top(); --> Returns 0.
 * minStack.getMin(); --> Returns -2.
 *
 *
 *
 *
 *
 * Difficulty:     Easy
 * TestCase:       ["MinStack","push","push","push","getMin","pop","top","getMin"], [[],[-2],[0],[-3],[],[],[],[]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._155

import java.util.*
import kotlin.math.min

class MinStack() {

    /** initialize your data structure here. */

    private val stack = Stack<Int>()
    private val minStack = Stack<Int>()

    fun push(x: Int) {
        stack.push(x)
        val newMin = if (minStack.isEmpty()) {
            x
        } else {
            min(minStack.peek(), x)
        }
        minStack.push(newMin)
    }

    fun pop() {
        if (stack.isEmpty()) return
        stack.pop()
        minStack.pop()
    }

    fun top(): Int = stack.peek()

    fun getMin(): Int = minStack.peek()

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */