/**
 * [130] Surrounded Regions
 *
 * https://leetcode-cn.com/problems/surrounded-regions/description/
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 *
 * After running your function, the board should be:
 *
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 *
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 *
 * Difficulty:     Medium
 * TestCase:       [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._130


/**
 * 先把边界上的 X 以及连通的 X 改成 #
 * 再把剩余的 X 改成 O
 * 最后把 # 改回 X
 */
class Solution {
    fun solve(board: Array<CharArray>?): Unit {
        if (board == null || board.size < 3 || board[0].size < 3) return
        val m = board.size
        val n = board[0].size

        val visited = Array(m) { BooleanArray(n) }

        for (i in 0 until m) {
            dfs(board, i, 0, visited)
            dfs(board, i, n - 1, visited)
        }

        for (j in 0 until n) {
            dfs(board, 0, j, visited)
            dfs(board, m - 1, j, visited)
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                when (board[i][j]) {
                    'O' -> board[i][j] = 'X'
                    '#' -> board[i][j] = 'O'
                }
            }
        }
    }

    private fun dfs(board: Array<CharArray>, i: Int, j: Int, visited: Array<BooleanArray>) {
        if (i !in 0 until board.size || j !in 0 until board[i].size) return
        if (visited[i][j]) return
        visited[i][j] = true

        val ch = board[i][j]
        if (ch == 'O') {
            board[i][j] = '#'
            dfs(board, i - 1, j, visited)
            dfs(board, i + 1, j, visited)
            dfs(board, i, j - 1, visited)
            dfs(board, i, j + 1, visited)
        }
    }
}