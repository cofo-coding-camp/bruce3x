import kotlinx.coroutines.runBlocking
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option

@Suppress("UnstableApiUsage")
open class FetchProblemTask : DefaultTask() {

    @Option(option = "url", description = "LeetCode problem url.")
    var url: String = ""

    @Option(option = "id", description = "Question id")
    var id: String = ""

    private val titleRegex = "https://leetcode\\.com/problems/(.+)/description/".toRegex()

    @TaskAction
    fun run() {
        runBlocking {
            FileGenerator(project, problem()).execute()
        }
    }

    private suspend fun problem(): Problem {
        return if (id.isNotBlank()) {
            LcService.problemById(id)
        } else {
            val title = titleRegex.find(url)?.groupValues?.getOrNull(1)
            if (title != null) {
                LcService.problem(title)
            } else {
                throw IllegalArgumentException("Invalid problem: id=$id or url=$url")
            }
        }
    }
}