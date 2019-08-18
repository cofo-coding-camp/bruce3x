import org.json.JSONArray
import org.json.JSONObject

class Problem(
    var id: String,
    val title: String,
    val titleSlug: String,
    val content: String,
    val difficulty: String,
    codeDefinition: String,
    val sampleTestCase: String,
    var ac: Float = 0F
) {
    val defaultCode: String =
        JSONArray(codeDefinition)
            .mapNotNull { it as? JSONObject }
            .mapNotNull { it.takeIf { it.optString("value") == "kotlin" }?.optString("defaultCode") }
            .firstOrNull()
            ?: ""
}

class ProblemGraphQuery(title: String) {
    val operationName = "getQuestionDetail"
    val variables = mapOf("titleSlug" to title)
    val query =
        """
            query getQuestionDetail(${"$"}titleSlug: String!) {
                question(titleSlug: ${"$"}titleSlug) {
                    questionId
                    questionTitle
                    questionTitleSlug
                    content
                    difficulty
                    codeDefinition
                    sampleTestCase
                }
          }
      """.trimIndent()
}

