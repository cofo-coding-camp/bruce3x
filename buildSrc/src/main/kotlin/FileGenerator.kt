import org.gradle.api.Project
import org.jsoup.Jsoup
import java.io.File

class FileGenerator(private val project: Project, private val problem: Problem) {

    fun execute() {
        sourceFile()
        testFile()
    }

    private fun testFile() {
        val dir = project.file("./src/test/kotlin/com/bruce3x/leetcode/")
        File(dir, "${problem.questionId}.kt").writer().use {
            it.write("@file:Suppress(\"PackageDirectoryMismatch\")")
            it.write("\n\n")
            it.write("package com.bruce3x.leetcode._${problem.questionId}")
            it.write("\n\n")
            it.write("import org.junit.Assert.*")
            it.write("\n")
            it.write("import org.junit.Test")
            it.write("\n\n\n")
            it.write(
                """
class SolutionTest {
    @Test
    fun test() {

    }
}
            """.trim()
            )
        }
    }

    private fun sourceFile() {
        val dir = project.file("./src/main/kotlin/com/bruce3x/leetcode/")
        val content = problem.content
            .lines()
            .map { Jsoup.parse(it).text() }
//            .filter { it.isNotBlank() }
            .joinToString(separator = "\n") { " * $it" }

        val header = """
/**
 * [${problem.questionId}] ${problem.questionTitle}
 *
 * https://leetcode-cn.com/problems/${problem.questionTitleSlug}/description/
 *
$content
 *
 * ${"Difficulty:     ${problem.difficulty}"}
 * ${"TestCase:       ${problem.sampleTestCase.replace("\n", ", ")}"}
 */
""".trim()


        File(dir, "${problem.questionId}.kt").writer().use {
            it.write(header)
            it.write("\n\n")
            it.write("@file:Suppress(\"PackageDirectoryMismatch\")")
            it.write("\n\n")
            it.write("package com.bruce3x.leetcode._${problem.questionId}")
            it.write("\n\n")
            it.write(problem.defaultCode)
        }
    }
}