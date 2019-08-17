/**
 * [473] Matchsticks to Square
 *
 * https://leetcode-cn.com/problems/matchsticks-to-square/description/
 *
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
 *
 * Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 *
 * Example 1:
 *
 * Input: [1,1,2,2,2]
 * Output: true
 *
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 *
 *
 *
 * Example 2:
 *
 * Input: [3,3,3,3,4]
 * Output: false
 *
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 *
 *
 *
 * Note:
 *
 * The length sum of the given matchsticks is in the range of 0 to 10^9.
 * The length of the given matchstick array will not exceed 15.
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       [1,1,2,2,2]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._473

class Solution {
    fun makesquare(nums: IntArray?): Boolean {
        if (nums == null || nums.isEmpty()) return false

        val sum = nums.sum()
        if (sum % 4 != 0) return false
        nums.sort()
        return dfs(nums, sum / 4, 1, 0, 0, BooleanArray(nums.size))
    }

    private fun dfs(
        nums: IntArray,
        edgeLength: Int,
        edgeId: Int,
        tmpLength: Int,
        pos: Int,
        visited: BooleanArray
    ): Boolean {
        // 前三条边凑够了，第四条自然没问题
        if (edgeId == 4) return true
        // 当前长度凑够了一条边长，去凑下一个边长
        if (tmpLength == edgeLength) return dfs(nums, edgeLength, edgeId + 1, 0, 0, visited)
        // 不能正好凑够边长
        if (tmpLength > edgeLength) return false

        for (i in pos until nums.size) {
            if (visited[i]) continue
            // 和上一个值一样凑不够边长
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1].not()) continue

            visited[i] = true
            if (dfs(nums, edgeLength, edgeId, tmpLength + nums[i], i + 1, visited)) return true
            visited[i] = false
        }

        return false
    }

    fun makesquare2(nums: IntArray?): Boolean {
        if (nums == null || nums.isEmpty()) return false

        val sum = nums.sum()
        if (sum % 4 != 0) return false
        nums.sort()
        return dfs2(nums, nums.size - 1, sum / 4, 0, 0, 0, 0)
    }

    private fun dfs2(
        nums: IntArray,
        pos: Int,
        edgeLength: Int,
        edge1: Int,
        edge2: Int,
        edge3: Int,
        edge4: Int
    ): Boolean {
        if (pos < 0) {
            return edge1 == edgeLength
                    && edge2 == edgeLength
                    && edge3 == edgeLength
                    && edge4 == edgeLength
        }

        if (edge1 > edgeLength || edge2 > edgeLength || edge3 > edgeLength || edge4 > edgeLength) return false

        return dfs2(nums, pos - 1, edgeLength, edge1 + nums[pos], edge2, edge3, edge4)
                || dfs2(nums, pos - 1, edgeLength, edge1, edge2 + nums[pos], edge3, edge4)
                || dfs2(nums, pos - 1, edgeLength, edge1, edge2, edge3 + nums[pos], edge4)
                || dfs2(nums, pos - 1, edgeLength, edge1, edge2, edge3, edge4 + nums[pos])
    }
}