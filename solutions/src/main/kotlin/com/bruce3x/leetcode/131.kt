/**
 * [131] Palindrome Partitioning
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning/description/
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 *
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 *
 *
 *
 * Difficulty:     Medium
 * Acceptance:     63.6 %
 * TestCase:       "aab"
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._131

import java.util.*

class Solution {
    fun partition(s: String): List<List<String>> {
        val results = LinkedList<List<String>>()
        val dp = Array(s.length) { BooleanArray(s.length) }
        for (j in 0 until s.length) {
            for (i in 0..j) {
                dp[i][j] = when {
                    i == j -> true
                    i + 1 < j - 1 -> s[i] == s[j] && dp[i + 1][j - 1]
                    else -> s[i] == s[j]
                }
            }
        }
        dfs(s, 0, dp, results, LinkedList())
        return results
    }

    private fun dfs(
        s: String,
        start: Int,
        dp: Array<BooleanArray>,
        results: LinkedList<List<String>>,
        tmp: LinkedList<String>
    ) {
        if (start == s.length) {
            if (tmp.isNotEmpty()) results.add(tmp.toList())
            return
        }

        for (end in start until s.length) {
            if (dp[start][end]) {
                tmp.addLast(s.substring(start, end + 1))
                dfs(s, end + 1, dp, results, tmp)
                tmp.removeLast()
            }
        }
    }
}