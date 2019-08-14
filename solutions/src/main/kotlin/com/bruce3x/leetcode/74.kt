/**
 * [74] Search a 2D Matrix
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 *
 * Example 1:
 *
 *
 * Input:
 * matrix = [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input:
 * matrix = [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 *
 *
 * Difficulty:     Medium
 * TestCase:       [[1,3,5,7],[10,11,16,20],[23,30,34,50]], 3
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._74

class Solution {
    fun searchMatrix(matrix: Array<IntArray>?, target: Int): Boolean {
        if (matrix == null || matrix.isEmpty() || matrix.first().isEmpty()) return false

        var l = 0
        var r = matrix.size * matrix.first().size - 1
        while (l <= r) {
            val mid = (l + r) / 2
            val value = getValue(matrix, mid)
            if (value == target) return true

            if (value < target) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return false
    }

    private fun getValue(matrix: Array<IntArray>, index: Int): Int =
        matrix.first().size.let { col ->
            matrix[index / col][index % col]
        }
}