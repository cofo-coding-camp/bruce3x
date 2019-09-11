/**
 * [127] Word Ladder
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 *
 * Note:
 *
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 *
 * Example 1:
 *
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 *
 * Example 2:
 *
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 *
 *
 *
 *
 *
 * Difficulty:     Medium
 * Acceptance:     36.6 %
 * TestCase:       "hit", "cog", ["hot","dot","dog","lot","log","cog"]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._127

import java.util.LinkedList
import java.util.Queue
import kotlin.collections.HashSet

class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val dict = HashSet(wordList)
        if (endWord !in dict) return 0

        val queue: Queue<String> = LinkedList()
        queue.offer(beginWord)

        val len = beginWord.length
        var step = 0

        while (queue.isNotEmpty()) {
            step++
            var size = queue.size
            while (size-- > 0) {
                val w = queue.poll()
                for (i in 0 until len) {
                    for (j in 'a'..'z') {
                        if (j == w[i]) continue
                        val modified = w.setCharAt(i, j)
                        if (modified == endWord) return step + 1
                        if (modified !in dict) continue
                        dict.remove(modified)
                        queue.offer(modified)
                    }
                }
            }
        }
        return 0
    }

    fun ladderLength2(beginWord: String, endWord: String, wordList: List<String>): Int {
        val dict = HashSet(wordList)
        if (endWord !in dict) return 0

        val len = beginWord.length
        var step = 0

        var q1 = hashSetOf(beginWord)
        var q2 = hashSetOf(endWord)

        while (q1.isNotEmpty() && q2.isNotEmpty()) {
            step++

            if (q1.size > q2.size) {
                val tmp = q1
                q1 = q2
                q2 = tmp
            }

            val q = HashSet<String>()

            for (w in q1) {
                for (i in 0 until len) {
                    for (j in 'a'..'z') {
                        if (j == w[i]) continue
                        val modified = w.setCharAt(i, j)
                        if (q2.contains(modified)) return step + 1
                        if (modified !in dict) continue
                        dict.remove(modified)
                        q.add(modified)
                    }
                }
            }
            q1 = q
        }
        return 0
    }

    private fun String.setCharAt(index: Int, ch: Char): String {
        return String(toCharArray().apply { set(index, ch) })
    }
}