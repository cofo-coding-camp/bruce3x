/**
 * [319] Bulb Switcher
 *
 * https://leetcode-cn.com/problems/bulb-switcher/description/
 *
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the i-th round, you toggle every i bulb. For the n-th round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 *
 * Example:
 *
 *
 * Input: 3
 * Output: 1
 * Explanation:
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off].
 *
 * So you should return 1, because there is only one bulb is on.
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       3
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._319

import kotlin.math.floor
import kotlin.math.sqrt

class Solution {
    fun bulbSwitch2(n: Int): Int {
        if (n <= 0) return 0
        if (n < 3) return 1

        val bulbs = BooleanArray(n) { true }
        for (i in 1 until n step 2) bulbs[i] = false

        for (i in 2 until n) {
            for (j in i until n step i + 1) bulbs[j] = !bulbs[j]
            println(bulbs.joinToString{if (it) "on " else "off"})
        }
        println("-".repeat(20))
        return bulbs.count { it }
    }

    /**
     * 灯泡初始状态全都是灭的
     * 第 i 轮，切换每第 i 个灯泡的状态
     * 完全平方数的因子数为奇数个 如 4=1x4, 2x2  => 1, 2, 4  切换奇数次状态，最终为亮灯状态
     * 非完全平方数的因子数成对出现，偶数个，切换偶数次状态，还是灭灯状态
     * 最终找到 <= n 的完全平方数个数即可
     */
    fun bulbSwitch(n:Int):Int{
        return floor(sqrt(n.toDouble())).toInt()
    }
}