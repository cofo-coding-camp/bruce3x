/**
 * [120] Triangle
 *
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 *
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 *
 * Difficulty:     Medium
 * TestCase:       [[2],[3,4],[6,5,7],[4,1,8,3]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._120

import kotlin.math.min

class Solution {
    fun minimumTotal(triangle: List<List<Int>>?): Int {
        if (triangle == null || triangle.isEmpty()) return 0

        val n = triangle.size
        val dp = IntArray(n)

        for (i in n - 1 downTo 0) {
            for (j in 0..i) {
                dp[j] = when (i) {
                    n - 1 -> 0                       // 最后一行的话，没有下一行提供的最小值，则为0
                    else -> min(dp[j], dp[j + 1])    // 下一行的最小值为左右两个斜线的值 min
                } + triangle[i][j]
            }
        }
        return dp[0]
    }
}