/**
 * [72] Edit Distance
 *
 * https://leetcode-cn.com/problems/edit-distance/description/
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Example 1:
 *
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 *
 * Example 2:
 *
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 *
 *
 * Difficulty:     Hard
 * TestCase:       "horse", "ros"
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._72

import kotlin.math.min

/**
 * C[i,j] =
 *    i                                                ( j = 0  )
 *    j                                                ( i = 0  )
 *    C[i-1, j-1]-1 )                                  ( X[i] == Y[j] )
 *    min( C[i, j-1], C[i-1, j], C[i-1, j-1] ) +1      ( X[i] != Y[j] )
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
                        dp[i][j - 1],
                        dp[i - 1][j - 1]
                    )
                }
                j++
            }
            i++
        }

        return dp[s1.length][s2.length]
    }

    private fun min(a: Int, b: Int, c: Int) = min(a, min(b, c))
}