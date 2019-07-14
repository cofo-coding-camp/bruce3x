import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option

open class FetchProblemTask : DefaultTask() {

    @Option(option = "url", description = "LeetCode problem url.")
    var url: String = ""

    @TaskAction
    fun run() {
        if (url.isNotEmpty()) {
            print(">>>>>>>>>>>>. fetch $url")
        } else {
            print(">>>>>>>>>>>>. invalid problem url")
        }
    }
}