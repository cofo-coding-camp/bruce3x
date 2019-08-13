/**
 * [63] Unique Paths II
 *
 * https://leetcode-cn.com/problems/unique-paths-ii/description/
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 *
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 *
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [[0,0,0],[0,1,0],[0,0,0]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._63

class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>?): Int {
        if (obstacleGrid == null) return 0
        val m = obstacleGrid.size
        val n = obstacleGrid.first().size
        if (m <= 0 || n <= 0) return 0

        val dp = Array(m) { IntArray(n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                dp[i][j] =
                    if (obstacleGrid[i][j] == 1) {
                        0
                    } else if (i == 0 && j == 0) {
                        1
                    } else if (i == 0) {
                        dp[i][j - 1]
                    } else if (j == 0) {
                        dp[i - 1][j]
                    } else {
                        dp[i][j - 1] + dp[i - 1][j]
                    }
            }
        }
        return dp[m - 1][n - 1]
    }
}