/**
 * [79] Word Search
 *
 * https://leetcode-cn.com/problems/word-search/description/
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 *
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 *
 *
 * Difficulty:     Medium
 * Acceptance:     39.0 %
 * TestCase:       [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED"
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._79

class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board.first().size

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (dfs(board, word, 0, i, j)) return true
            }
        }
        return false
    }

    private fun dfs(board: Array<CharArray>, word: String, index: Int, x: Int, y: Int): Boolean {
        if (index >= word.length) return true
        if (x !in board.indices || y !in board[x].indices || word[index] != board[x][y]) return false

        val ch = board[x][y]
        board[x][y] = 0.toChar()
        val found = dfs(board, word, index + 1, x - 1, y)
                || dfs(board, word, index + 1, x + 1, y)
                || dfs(board, word, index + 1, x, y - 1)
                || dfs(board, word, index + 1, x, y + 1)
        board[x][y] = ch
        return found
    }
}