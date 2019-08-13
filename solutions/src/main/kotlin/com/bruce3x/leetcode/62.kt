/**
 * [62] Unique Paths
 *
 * https://leetcode-cn.com/problems/unique-paths/description/
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 *
 * Example 2:
 *
 *
 * Input: m = 7, n = 3
 * Output: 28
 *
 *
 * Difficulty:     Medium
 * TestCase:       3, 2
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._62

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        if (m <= 0 || n <= 0) return 0

        val dp = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                dp[i][j] =
                    if (i == 0 && j == 0) {
                        // origin
                        1
                    } else if (i == 0) {
                        // top edge
                        dp[i][j - 1]
                    } else if (j == 0) {
                        // left edge
                        dp[i - 1][j]
                    } else {
                        // ⬇ + ➡
                        dp[i - 1][j] + dp[i][j - 1]
                    }

            }
        }
        return dp[m - 1][n - 1]
    }
}