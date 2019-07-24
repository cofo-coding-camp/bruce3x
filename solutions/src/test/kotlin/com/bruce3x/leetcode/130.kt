@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._130

import org.junit.Assert
import org.junit.Test


typealias CharMatrix = Array<CharArray>


infix fun CharMatrix.contentEquals(other: CharMatrix): Boolean {
    if (this.size != other.size) return false
    for (i in 0 until size) {
        if (this[i] contentEquals other[i]) continue
        return false
    }
    return true
}

fun CharMatrix.print(): String = joinToString(separator = "\n") { it.joinToString(separator = " ") }.also(::println)

class SolutionTest {
    @Test
    fun test() {
        val solution = Solution()

        Assert.assertTrue(
            arrayOf(
                charArrayOf('X', 'X', 'X', 'X'),
                charArrayOf('X', 'X', 'X', 'X'),
                charArrayOf('X', 'X', 'X', 'X'),
                charArrayOf('X', 'O', 'X', 'X')
            )
                    contentEquals
                    arrayOf(
                        charArrayOf('X', 'X', 'X', 'X'),
                        charArrayOf('X', 'O', 'O', 'X'),
                        charArrayOf('X', 'X', 'O', 'X'),
                        charArrayOf('X', 'O', 'X', 'X')
                    )
                        .also(solution::solve)
                        .also { it.print() }
        )

    }
}