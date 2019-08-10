@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._319

import org.junit.Assert.*
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        /**
         * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
           第一轮后, 灯泡状态 [开启, 开启, 开启].
           第二轮后, 灯泡状态 [开启, 关闭, 开启].
           第三轮后, 灯泡状态 [开启, 关闭, 关闭].
         */
        assertEquals(1, solution.bulbSwitch(3))

        /**
         * on on on on
         * on of on of
         * on of of of
         * on of of on
         */
        assertEquals(2, solution.bulbSwitch(4))
        /**
         * on on on on on
         * on of on of on
         * on of of of on
         * on of of on on
         * on of of on of
         */
        assertEquals(2, solution.bulbSwitch(5))
    }
}