/**
 * [282] Expression Add Operators
 *
 * https://leetcode-cn.com/problems/expression-add-operators/description/
 *
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 *
 * Example 1:
 *
 *
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"]
 *
 *
 * Example 2:
 *
 *
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 *
 * Example 3:
 *
 *
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 *
 * Example 4:
 *
 *
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 *
 *
 * Example 5:
 *
 *
 * Input: num = "3456237490", target = 9191
 * Output: []
 *
 *
 *
 * Difficulty:     Hard
 * Acceptance:     30.0 %
 * TestCase:       "123", 6
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._282

import java.util.LinkedList

class Solution {
    fun addOperators(num: String, target: Int): List<String> {
        val results = LinkedList<String>()
        dfs(num, target, 0, CharArray(num.length * 2) { Char.MIN_VALUE }, 0, 0, 0, results)
        println(results.joinToString(separator = "    "))
        return results
    }

    /**
     * @param exp               当前表达式
     * @param expLength         当前表达式所用长度
     * @param previousValue     前一个节点的值，（单个数字或者连乘积）
     * @param currentValue      当前表达式的值
     */
    private fun dfs(
        num: String,
        target: Int,
        start: Int,
        exp: CharArray,
        expLength: Int,
        previousValue: Int,
        currentValue: Int,
        results: LinkedList<String>
    ) {
        if (start == num.length) {
            if (currentValue == target) {
                results.add(String(exp, 0, expLength))
            }
            return
        }

        var n = 0
        var len = expLength
        // 留一个运算符的位置
        if (start > 0) ++len
        var i = start

        while (i < num.length) {
            // 0123 invalid number
            if (num[start] == '0' && i > start) break

            val next: Long = 10L * n + (num[i] - '0')
            // too large
            if (next > Int.MAX_VALUE) break

            n = next.toInt()
            exp[len++] = num[i++]

            if (start == 0) {
                dfs(num, target, i, exp, len, n, currentValue + n, results)
                continue
            }

            exp[expLength] = '+'
            dfs(num, target, i, exp, len, n, currentValue + n, results)

            exp[expLength] = '-'
            dfs(num, target, i, exp, len, -n, currentValue - n, results)

            exp[expLength] = '*'
            dfs(
                num, target, i, exp, len,
                previousValue * n,
                currentValue - previousValue + previousValue * n,
                results
            )
        }
    }
}