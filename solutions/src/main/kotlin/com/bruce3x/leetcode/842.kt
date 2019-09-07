/**
 * [842] Split Array into Fibonacci Sequence
 *
 * https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/description/
 *
 * Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].
 *
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:
 *
 *
 * 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
 * F.length >= 3;
 * and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
 *
 *
 * Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.
 *
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.
 *
 * Example 1:
 *
 *
 * Input: "123456579"
 * Output: [123,456,579]
 *
 *
 * Example 2:
 *
 *
 * Input: "11235813"
 * Output: [1,1,2,3,5,8,13]
 *
 *
 * Example 3:
 *
 *
 * Input: "112358130"
 * Output: []
 * Explanation: The task is impossible.
 *
 *
 * Example 4:
 *
 *
 * Input: "0123"
 * Output: []
 * Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
 *
 *
 * Example 5:
 *
 *
 * Input: "1101111"
 * Output: [110, 1, 111]
 * Explanation: The output [11, 0, 11, 11] would also be accepted.
 *
 *
 * Note:
 *
 *
 * 1 <= S.length <= 200
 * S contains only digits.
 *
 *
 *
 * Difficulty:     Medium
 * Acceptance:     32.2 %
 * TestCase:       "123456579"
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._842

import java.util.Stack

class Solution {
    fun splitIntoFibonacci(S: String): List<Int> {
        val result = Stack<Int>()
        dfs(S, 0, result)
        return if (result.size > 2) result else emptyList()
    }

    private fun dfs(S: String, start: Int, result: Stack<Int>): Boolean {
        if (start >= S.length) return result.size > 2

        var n = 0
        for (i in start until S.length) {
            if (S[start] == '0' && i > start) break

            val next = 10L * n + (S[i] - '0')
            if (next > Int.MAX_VALUE) break
            n = next.toInt()

            if (result.size >= 2 && result[result.size - 1] + result[result.size - 2] != n) continue

            result.push(n)
            if (dfs(S, i + 1, result)) return true
            result.pop()
        }
        return false
    }
}