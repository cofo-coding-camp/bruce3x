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

import kotlin.math.max

/**
 * LCS problem
 *
 * C[i,j] =
 *    0                                 ( i = 0 or j = 0 )
 *    C[i-1, j-1]                       (  X[i] == Y[j]  )
 *    max( C[i, j-1], C[i-1, j] )       (  X[i] == Y[j]  )
 */
class Solution {
    fun minDistance(word1: String?, word2: String?): Int {
        val s1 = word1.orEmpty()
        val s2 = word2.orEmpty()
        val len = lcsLengthIterative(s1, s2)
        return s1.length + s2.length - 2 * len
    }

    private fun lcsLengthRecursively(s1: String, s2: String): Int =
        lcsLengthRecursively(s1, s2, s1.length - 1, s2.length - 1)

    private fun lcsLengthRecursively(s1: String, s2: String, i: Int, j: Int): Int {
        return when {
            i < 0 || j < 0 -> 0
            s1[i] == s2[j] -> lcsLengthRecursively(s1, s2, i - 1, j - 1) + 1
            else -> max(
                lcsLengthRecursively(s1, s2, i - 1, j),
                lcsLengthRecursively(s1, s2, i, j - 1)
            )
        }
    }


    private fun lcsLengthIterative(s1: String, s2: String): Int {
        val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }
        var i = 1

        while (i <= s1.length) {
            var j = 1
            while (j <= s2.length) {
                dp[i][j] = if (s1[i - 1] == s2[j - 1]) {
                    dp[i - 1][j - 1] + 1
                } else {
                    max(dp[i - 1][j], dp[i][j - 1])
                }

                j++
            }
            i++
        }

        return dp[s1.length][s2.length]
    }

}