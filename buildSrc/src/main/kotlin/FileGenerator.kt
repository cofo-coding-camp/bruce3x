import org.jsoup.Jsoup
import java.io.File

class FileGenerator(private val problem: Problem, private val dir: File) {

    fun execute() {
        val content = problem.content
            .lines()
            .map { Jsoup.parse(it).text() }
//            .filter { it.isNotBlank() }
            .joinToString(separator = "\n") { " * $it" }

        val header = """
/**
 * [${problem.questionId}] ${problem.questionTitle}
 *
 * https://leetcode.com/problems/${problem.questionTitleSlug}/description/
 *
$content
 *
 * ${"Difficulty:     ${problem.difficulty}"}
 * ${"TestCase:       ${problem.sampleTestCase.replace("\n",", ")}"}
 */
""".trim()


        File(dir, "${problem.questionId}.kt").writer().use {
            it.write(header)
            it.write("\n\n")
            it.write("@file:Suppress(\"PackageDirectoryMismatch\")\n")
            it.write("package com.bruce3x.leetcode._${problem.questionId}")
            it.write("\n\n")
            it.write(problem.defaultCode)
        }
    }
}