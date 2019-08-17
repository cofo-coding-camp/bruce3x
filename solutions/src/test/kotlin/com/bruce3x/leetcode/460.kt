@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._460

import org.junit.Assert.assertEquals
import org.junit.Test


class SolutionTest {
    @Test
    fun test() {
        with(LFUCache(2)) {
            put(1, 1)
            put(2, 2)
            assertEquals(1, get(1))
            put(3, 3)
            assertEquals(-1, get(2))
            assertEquals(3, get(3))
            put(4, 4)
            assertEquals(-1, get(1))
            assertEquals(3, get(3))
            assertEquals(4, get(4))
        }

        println("----------------------------------")

        with(LFUCache(3)) {
            put(2, 2)

            put(1, 1)

            assertEquals(2, get(2))

            assertEquals(1, get(1))

            assertEquals(2, get(2))

            put(3, 3)

            put(4, 4)

            assertEquals(-1, get(3))

            assertEquals(2, get(2))

            assertEquals(1, get(1))

            assertEquals(4, get(4))

        }

        println("----------------------------------")

        with(LFUCache(0)) {
            put(0, 0)
            assertEquals(-1, get(0))
        }

        println("----------------------------------")


        /**
         * ["LFUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
        [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
        [null,null,   null,  null,  null,  null,  -1,  null,  19, 17, null,  -1,  null, null,  null, -1,  null,  -1,  5, -1, 12, null,  null, 3,   5,    5,  null, null,  1,  null,  -1,  null, 30,  5, 30,  null,  null,   null,  -1,  null, -1,  24,  null,  null, 18, null,  null,  null,  null,14,  null,  null, 18,  null,  null,  11,  null,  null,  null,   null,  null, 18,  null, null,   -1,  null, 4,  29, 30,  null,12, 11,  null,null,null,null,          29,null,null,null,null,        17, -1, 18,null,null,null,          -1,null,null,null,       20,null,null,null,       29, 18, 18,null,null,null,null,        20,null,null,null,null,null,null,null]
         */

        with(LFUCache(10)) {
            put(10, 13)

            put(3, 17)

            put(6, 11)

            put(10, 5)

            put(9, 10)

            assertEquals(-1, get(13))

            put(2, 19)

            assertEquals(19, get(2))

            assertEquals(17, get(3))

            put(5, 25)

            assertEquals(-1, get(8))

            put(9, 22)

            put(5, 5)

            put(1, 30)

            assertEquals(-1, get(11))

            put(9, 12)

            assertEquals(-1, get(7))

            assertEquals(5, get(5))

            assertEquals(-1, get(8))

            assertEquals(12, get(9))

            put(4, 30)

            put(9, 3)

            assertEquals(3, get(9))

            assertEquals(5, get(10))

            assertEquals(5, get(10))

            println(">>")
            put(6, 14)
            println(">>")

            put(3, 1)
            assertEquals(1, get(3))
            put(10, 11)
            assertEquals(-1, get(8))

            put(2, 14)

            assertEquals(30, get(1))

            assertEquals(5, get(5))

            assertEquals(30, get(4))

            put(11, 4)

            put(12, 24)

            put(5, 18)

            assertEquals(-1, get(13))

            put(7, 23)

            assertEquals(-1, get(8))

            assertEquals(24, get(12))

            put(3, 27)

            put(2, 12)

            assertEquals(18, get(5))

            put(2, 9)

            put(13, 4)

            put(8, 18)

            put(1, 7)

            assertEquals(14, get(6))
            put(9, 29)

            put(8, 21)

            assertEquals(18, get(5))

            put(6, 30)

            put(1, 12)

            assertEquals(11, get(10))

            put(4, 15)

            put(7, 22)

            put(11, 26)

            put(8, 17)

            put(9, 29)

            assertEquals(18, get(5))

            put(3, 4)

            put(11, 30)

            assertEquals(-1, get(12))

            put(4, 29)

            assertEquals(4, get(3))

            assertEquals(29, get(9))

            assertEquals(30, get(6))

            put(3, 4)

            assertEquals(12, get(1))

            assertEquals(11, get(10))

            put(3, 29)

            put(10, 28)

            put(1, 20)

            put(11, 13)

            assertEquals(29, get(3))

            put(3, 12)

            put(3, 8)

            put(10, 9)

            put(3, 26)

            assertEquals(17, get(8))

            assertEquals(-1, get(7))

            assertEquals(18, get(5))

            put(13, 17)

            put(2, 27)

            put(11, 15)

            assertEquals(-1, get(12))

            put(9, 19)

            put(2, 15)

            put(3, 16)

            assertEquals(20, get(1))

            put(12, 17)

            put(9, 1)

            put(6, 19)

            assertEquals(29, get(4))

            assertEquals(18, get(5))

            assertEquals(18, get(5))

            put(8, 1)

            put(11, 7)

            put(5, 2)

            put(9, 28)

            assertEquals(20, get(1))

            put(2, 2)

            put(7, 4)

            put(4, 22)

            put(7, 24)

            put(9, 26)

            put(13, 28)

            put(11, 26)

        }
    }
}