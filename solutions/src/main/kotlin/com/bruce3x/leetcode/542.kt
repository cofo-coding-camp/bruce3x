/**
 * [542] 01 Matrix
 *
 * https://leetcode-cn.com/problems/01-matrix/description/
 *
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 *
 *
 * Example 2:
 *
 *
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [1,2,1]]
 *
 *
 *
 *
 * Note:
 *
 *
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 *
 *
 *
 * Difficulty:     Medium
 * Acceptance:     34.6 %
 * TestCase:       [[0,0,0],[0,1,0],[0,0,0]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._542

import java.util.LinkedList

class Solution {
    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val m = matrix.size
        val n = matrix.first().size

        val output = Array(m) { IntArray(n) }
        val visited = Array(m) { BooleanArray(n) }
        val queue = LinkedList<Pair<Int, Int>>()

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) {
                    visited[i][j] = true
                    queue.add(i to j)
                }
            }
        }

        val dirs = intArrayOf(0, -1, 0, 1, 0)
        // 从 0 节点开始向外 bfs，每循环一层，距离 +1
        var distance = 0
        while (queue.isNotEmpty()) {
            var size = queue.size
            while (size-- > 0) {
                val (x, y) = queue.remove()
                output[x][y] = distance
                for (i in 0 until 4) {
                    val xx = x + dirs[i + 1]
                    val yy = y + dirs[i]

                    if (xx in 0 until m && yy in 0 until n && !visited[xx][yy]) {
                        visited[xx][yy] = true
                        queue.add(xx to yy)
                    }
                }
            }
            distance++
        }

        return output
    }
}