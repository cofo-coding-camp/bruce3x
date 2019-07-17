/**
 * [207] Course Schedule
 *
 * https://leetcode-cn.com/problems/course-schedule/description/
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 *
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 *
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 *
 *
 * Note:
 *
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *
 *
 *
 * Difficulty:     Medium
 * TestCase:       2, [[1,0]]
 */

@file:Suppress("PackageDirectoryMismatch")

package com.bruce3x.leetcode._207

import java.util.*

class Solution {

    /**
     * 1. calc indegree of each course ( amount of courses that it is dependent on )
     * 2. push 0 indegree courses into queue
     * 3. move a course from queue to result list, recheck indegree
     * 4. loop #3, until queue is empty
     * 5. return result size == course amount,
     */
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        if (numCourses <= 0) return false
        if (prerequisites.isEmpty()) return true

        // calc indegree if each course
        val inDegrees = IntArray(numCourses)
        prerequisites.forEach { (course, _) ->
            inDegrees[course]++
        }

        // all independent courses (inDegree = 0)
        val queue: Queue<Int> = LinkedList()
        inDegrees.forEachIndexed { index, inDegree ->
            if (inDegree == 0) queue.offer(index)
        }


        val order = arrayListOf<Int>()
        while (queue.isNotEmpty()) {
            val orderedCourse = queue.poll()
            order.add(orderedCourse)

            // recheck indegree
            prerequisites.forEach { (course, dependency) ->
                if (orderedCourse == dependency) {
                    inDegrees[course]--

                    // new independent course
                    if (inDegrees[course] == 0) queue.offer(course)
                }
            }
        }
        return order.size == numCourses
    }
}