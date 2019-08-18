import org.gradle.api.Plugin
import org.gradle.api.Project

class LeetCodePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        mapOf(
            "problem" to FetchProblemTask::class,
            "checkProblems" to CheckIdTask::class
        ).forEach { (name, task) ->
            target.task(
                mapOf(
                    "type" to task.java,
                    "group" to "leetcode"
                ),
                name
            )
        }
    }
}