import org.gradle.api.Plugin
import org.gradle.api.Project

class LeetCodePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.task(mapOf("type" to FetchProblemTask::class.java, "group" to "leetcode"), "fetchProblem")
    }
}