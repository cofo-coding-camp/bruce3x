/**
 * [583] Delete Operation for Two Strings
 *
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/description/
 *
 *
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 *
 *
 * Example 1:
 *
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 *
 *
 *
 * Note:
 *
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       "sea", "eat"
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._583

import kotlin.math.min

/**
 * LCS problem
 *
 * C[i,j] =
 *    j                                 ( i = 0 )
 *    i                                 ( j = 0 )
 *    C[i-1, j-1]                       ( X[i] == Y[j] )
 *    min( C[i, j-1], C[i-1, j] )       ( X[i] != Y[j] )
 */
class Solution {
    fun minDistance(word1: String?, word2: String?): Int {
        val s1 = word1.orEmpty()
        val s2 = word2.orEmpty()

        val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }

        for (i in 0..s1.length) dp[i][0] = i
        for (j in 0..s2.length) dp[0][j] = j

        var i = 1
        while (i <= s1.length) {
            var j = 1
            while (j <= s2.length) {
                dp[i][j] = if (s1[i - 1] == s2[j - 1]) {
                    dp[i - 1][j - 1]
                } else {
                    1 + min(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    )
                }

                j++
            }
            i++
        }

        return dp[s1.length][s2.length]
    }
}