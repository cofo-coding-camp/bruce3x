/**
 * [233] Number of Digit One
 *
 * https://leetcode-cn.com/problems/number-of-digit-one/description/
 *
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 *
 * Example:
 *
 *
 * Input: 13
 * Output: 6
 * Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 *
 *
 *
 * Difficulty:     Hard
 * TestCase:       13
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._233

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun countDigitOne(n: Int): Int {
        var count = 0L
        var i = 1L
        while (i <= n) {
            val div :Long= i * 10
            count += (n / div * i + min(i, max(n % div - i + 1, 0L)))
            i *= 10
        }
        return count.toInt()
    }

}