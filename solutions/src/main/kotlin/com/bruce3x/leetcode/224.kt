/**
 * [224] Basic Calculator
 *
 * https://leetcode-cn.com/problems/basic-calculator/description/
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * Example 1:
 *
 *
 * Input: "1 + 1"
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 *
 * Example 3:
 *
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 *
 *
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 *
 *
 *
 * Difficulty:     Hard
 * TestCase:       "1 + 1"
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._224

import java.util.*

class Solution {
    fun calculate(s: String): Int {
        val stack = Stack<Int>()
        var ans = 0
        var sign = 1

        var i = 0
        while (i < s.length) {
            val ch = s[i]
            when {
                // parse numbers
                ch.isDigit() -> {
                    var n = ch - '0'
                    while (i + 1 < s.length && s[i + 1].isDigit()) {
                        n = n * 10 + (s[i + 1] - '0')
                        i++
                    }
                    ans += (sign * n)
                }
                ch == '+' -> {
                    sign = 1
                }
                ch == '-' -> {
                    sign = -1
                }
                ch == '(' -> {
                    stack.push(ans)
                    stack.push(sign)
                    ans = 0
                    sign = 1
                }
                ch == ')' -> {
                    ans = ans * stack.pop() + stack.pop()
                }
                else -> {

                }
            }

            i++
        }

        return ans
    }
}