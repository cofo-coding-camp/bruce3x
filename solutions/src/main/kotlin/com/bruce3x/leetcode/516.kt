/**
 * [516] Longest Palindromic Subsequence
 *
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/description/
 *
 *
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 *
 *
 * Example 1:
 * Input:
 *
 * "bbbab"
 *
 * Output:
 *
 * 4
 *
 * One possible longest palindromic subsequence is "bbbb".
 *
 *
 * Example 2:
 * Input:
 *
 * "cbbd"
 *
 * Output:
 *
 * 2
 *
 * One possible longest palindromic subsequence is "bb".
 *
 *
 * Difficulty:     Medium
 * TestCase:       "bbbab"
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._516

import kotlin.math.max

class Solution {
    fun longestPalindromeSubseq(s: String?): Int {
        if (s == null) return 0
        return find(s, 0, s.length - 1)
    }

    private fun find(s: String, i: Int, j: Int): Int {
        if (i == j) return 1
        if (i > j) return 0

        if (s[i] == s[j]) return find(s, i + 1, j - 1) + 2
        return max(
            find(s, i + 1, j),
            find(s, i, j - 1)
        )
    }

    fun longestPalindromeSubseq2(s: String?): Int {
        if (s.isNullOrEmpty()) return 0
        val n = s.length
        val dp = Array(n) { IntArray(n) }

        for (i in n - 1 downTo 0) {
            dp[i][i] = 1
            for (j in i + 1 until n) {
                if (s[i] == s[j]) dp[i][j] = dp[i + 1][j - 1] + 2
                else dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
            }
        }

        return dp[0][n - 1]
    }
}