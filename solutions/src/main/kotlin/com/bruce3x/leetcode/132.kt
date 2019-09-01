/**
 * [132] Palindrome Partitioning II
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/description/
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 *
 *
 * Difficulty:     Hard
 * Acceptance:     40.1 %
 * TestCase:       "aab"
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._132

import kotlin.math.min

class Solution {
    fun minCut(s: String): Int {
        val dp = Array(s.length) { BooleanArray(s.length) }
        val cut = (0 until s.length).toList().toIntArray()

        for (j in 0 until s.length) {
            for (i in 0..j) {
                when {
                    i == j -> dp[i][j] = true
                    i + 1 < j - 1 -> dp[i][j] = s[i] == s[j] && dp[i + 1][j - 1]
                    else -> dp[i][j] = s[i] == s[j]
                }
                if (dp[i][j]) {
                    cut[j] = if (i > 0) min(cut[j], cut[i - 1] + 1) else 0
                }
            }
        }

        return cut[cut.size - 1]
    }
}