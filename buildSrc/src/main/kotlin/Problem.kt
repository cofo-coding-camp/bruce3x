import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class Problem {
    val questionId = ""
    val questionTitle = ""
    val questionTitleSlug = ""
    val content = ""
    val difficulty = ""
    private val codeDefinition = ""
    val sampleTestCase = ""

    val defaultCode: String
        get() {
            for (item in JSONArray(codeDefinition)) {
                val obj = (item as? JSONObject) ?: continue
                if (obj.optString("value") == "kotlin") {
                    return obj.optString("defaultCode")
                }
            }
            return ""
        }
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

class ProblemDeserializer : ResponseDeserializable<Problem> {
    override fun deserialize(content: String): Problem? {
        val q = JSONObject(content).getJSONObject("data").getJSONObject("question").toString()
        return Gson().fromJson(q, Problem::class.java)
    }
}