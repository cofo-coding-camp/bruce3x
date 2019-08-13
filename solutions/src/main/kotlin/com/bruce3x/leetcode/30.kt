/**
 * [30] Substring with Concatenation of All Words
 *
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * Example 1:
 *
 *
 * Input:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 *
 * Example 2:
 *
 *
 * Input:
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * Output: []
 *
 *
 *
 * Difficulty:     Hard
 * TestCase:       "barfoothefoobarman", ["foo","bar"]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._30

class Solution {
    fun findSubstring(s: String?, words: Array<String>?): List<Int> {
        if (s == null || words == null || s.isEmpty() || words.isEmpty()) return emptyList()

        val l = s.length
        val m = words.size
        val n = words.first().length

        val map = hashMapOf<String, Int>()
        val results = mutableListOf<Int>()

        for (i in 0..l - m * n) {
            map.clear()
            words.forEach { map[it] = 1 + (map[it] ?: 0) }
            for (j in i until i + m * n step n) {
                val word = s.substring(j, j + n)
                val count = map.getOrDefault(word, 0)
                if (count == 0) break
                map[word] = count - 1
            }

            if (map.values.all { it == 0 }) {
                results.add(i)
            }
        }
        return results
    }
}