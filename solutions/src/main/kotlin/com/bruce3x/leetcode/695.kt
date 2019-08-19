/**
 * [695] Max Area of Island
 *
 * https://leetcode-cn.com/problems/max-area-of-island/description/
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 *
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 *
 * Example 2:
 *
 *
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 *
 * Note: The length of each dimension in the given grid does not exceed 50.
 *
 *
 * Difficulty:     Medium
 * Acceptance:     85.9 %
 * TestCase:       [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._695

import kotlin.math.max

class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxArea = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                maxArea = max(maxArea, dfs(grid, i, j))
            }
        }
        return maxArea
    }

    private fun dfs(grid: Array<IntArray>, row: Int, col: Int): Int {
        if (row < 0 || row >= grid.size) return 0
        if (col < 0 || col >= grid[row].size) return 0
        if (grid[row][col] != 1) return 0

        grid[row][col] = -1
        return dfs(grid, row - 1, col) +
                dfs(grid, row + 1, col) +
                dfs(grid, row, col - 1) +
                dfs(grid, row, col + 1) +
                1
    }
}