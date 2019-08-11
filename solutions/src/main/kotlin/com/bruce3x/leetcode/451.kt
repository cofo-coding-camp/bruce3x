/**
 * [451] Sort Characters By Frequency
 *
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/description/
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 *
 *
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 *
 *
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       "tree"
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._451

import java.util.LinkedList
import kotlin.math.max

class Solution {
    fun frequencySort(s: String?): String? {
        if (s.isNullOrEmpty()) return s

        val fraq = hashMapOf<Char, Int>()
        var maxFraq = -1
        s.forEach {
            fraq[it] = 1 + (fraq[it] ?: 0)
            maxFraq = max(maxFraq, fraq[it] ?: 0)
        }

        val buckets = Array(maxFraq + 1) { LinkedList<Char>() }

        fraq.forEach { (ch, f) ->
            buckets[f].add(ch)
        }

        val sorted = CharArray(s.length)
        var index = 0

        for (f in buckets.size - 1 downTo 0) {
            for (ch in buckets[f]) {
                for (i in 0 until f) {
                    sorted[index++] = ch
                }
            }
        }

        return String(sorted)
    }
}