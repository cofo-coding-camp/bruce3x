/**
 * [149] Max Points on a Line
 *
 * https://leetcode-cn.com/problems/max-points-on-a-line/description/
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Example 1:
 *
 *
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |     o
 * |   o
 * | o
 * +------------->
 * 0 1 2 3 4
 *
 *
 * Example 2:
 *
 *
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * | o
 * |   o     o
 * |     o
 * | o     o
 * +------------------->
 * 0 1 2 3 4 5 6
 *
 *
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 *
 * Difficulty:     Hard
 * TestCase:       [[1,1],[2,2],[3,3]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._149

import kotlin.math.max

class Solution {
    fun maxPoints(points: Array<IntArray>): Int {
        if (points.isEmpty()) return 0
        if (points.size < 2) return 1

        var maxCount = 1

        for (i in 0..points.size - 2) maxCount = max(maxCount, maxCountOfPoint(points, i))
        return maxCount
    }

    private fun maxCountOfPoint(points: Array<IntArray>, index: Int): Int {
        val lines = HashMap<String, Int>().withDefault { 1 }

        val p1 = points[index]
        var j = index + 1

        var duplicates = 0
        var verticals = 1
        var count = 1

        while (j < points.size) {
            val p2 = points[j]
            if (p1[0] == p2[0] && p1[1] == p2[1]) {
                // 重复点
                duplicates++
            } else if (p1[0] == p2[0]) {
                // 垂直线
                verticals++
                count = max(verticals, count)
            } else {
                // 计算斜率
                val dy = p2[1] - p1[1]
                val dx = p2[0] - p1[0]
                // 除掉最大公约数，避免直接 dy/dx 精度丢失
                val gcd = gcd(dx, dy)
                val slope = "${dx/gcd}/${dy/gcd}"

                lines[slope] = lines.getValue(slope) + 1
                count = max(count, lines.getValue(slope))
            }

            j++
        }
        return duplicates + count
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}