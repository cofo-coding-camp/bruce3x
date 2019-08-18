import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option

@Suppress("UnstableApiUsage")
open class FetchProblemTask : DefaultTask() {

    @Option(option = "id", description = "Question id")
    var id: String = ""

    @TaskAction
    fun run() {
        val problemId = id.takeIf { it.isNotBlank() }
            ?: throw IllegalArgumentException("Invalid problem: id=$id")
        runBlocking(Dispatchers.Default) {
            FileGenerator(project, LcService.problemById(problemId)).execute()
        }
    }
}