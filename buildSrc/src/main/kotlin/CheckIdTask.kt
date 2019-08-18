import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.json.JSONObject

open class CheckIdTask : DefaultTask() {

    @TaskAction
    fun run() {
        runBlocking(Dispatchers.Default) {
            val finishedProblems = project.file("src/main/kotlin/com/bruce3x/leetcode")
                .listFiles()
                ?.mapNotNull { it.nameWithoutExtension.toIntOrNull() }
                ?: emptyList()

            val problems = LcService.allProblems().mapNotNull {
                (it as? JSONObject)?.optJSONObject("stat")?.run {
                    optInt("question_id") to optInt("frontend_question_id")
                }
            }.toMap()

            finishedProblems.forEach {
                val p = problems[it]
                if (p == null) {
                    println("can't find problem $it")
                } else if (p != it) {
                    println("find problem id error $it => $p")
                }
            }

            println("done. ${finishedProblems.size} finished problems.")
        }
    }
}
