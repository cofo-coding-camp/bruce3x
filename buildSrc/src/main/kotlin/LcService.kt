import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.coroutines.awaitObject
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import com.github.kittinunf.fuel.gson.jsonBody
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.json.jsonDeserializer
import org.json.JSONArray
import org.json.JSONObject

object LcService {

    private fun Request.wrapRequest(): Request {
        return request.header("Origin", "https://leetcode-cn.com")
            .header(
                "User-Agent",
                "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1"
            )
    }

    private suspend fun token(title: String): String {
        val page = "https://leetcode-cn.com/problems/$title/"
        val (_, response, _) = page.httpGet()
            .wrapRequest()
            .awaitStringResponseResult()
        val cookie = response.header("Set-Cookie").first()
        return "csrftoken=(\\w+);".toRegex().find(cookie)?.groupValues?.getOrNull(1)
            ?: throw  IllegalStateException("get token failed")
    }

    private suspend fun problem(frontId: String, title: String, ac: Float): Problem {
        val token = token(title)

        return "https://leetcode-cn.com/graphql".httpPost()
            .wrapRequest()
            .header("Referer", "https://leetcode-cn.com/problems/$title/")
            .header("x-csrftoken", token)
            .header("Cookie", "csrftoken=$token;")
            .jsonBody(ProblemGraphQuery(title))
//            .also { println(it) }
            .awaitObject(jsonDeserializer())
            .obj()
            .let {
                val q = it.optJSONObject("data")?.optJSONObject("question")
                    ?: throw IllegalArgumentException("invalid problem")
                Problem(
                    frontId,
                    q.optString("questionTitle"),
                    q.optString("questionTitleSlug"),
                    q.optString("content"),
                    q.optString("difficulty"),
                    q.optString("codeDefinition"),
                    q.optString("sampleTestCase"),
                    ac
                )
            }
    }

    suspend fun allProblems(): JSONArray {
        return "https://leetcode-cn.com/api/problems/all/".httpGet()
            .wrapRequest()
            .awaitObject(jsonDeserializer())
            .obj()
            .getJSONArray("stat_status_pairs")
    }

    suspend fun problemById(id: String): Problem {
        val (frontId, titleSlug, ac) =
            allProblems()
                .map {
                    (it as JSONObject).getJSONObject("stat")
                        .run {
                            Triple(
                                getInt("frontend_question_id").toString(),
                                optString("question__title_slug"),
                                optInt("total_acs") / 100F
                            )
                        }
                }
                .firstOrNull { it.first == id }
                ?: throw IllegalArgumentException("Problem #$id not found!")

        return problem(frontId, titleSlug, ac)
    }
}


