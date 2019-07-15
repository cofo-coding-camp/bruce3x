import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.coroutines.awaitObject
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import com.github.kittinunf.fuel.gson.jsonBody
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.json.jsonDeserializer
import org.json.JSONObject

object LcService {

    private fun Request.wrapRequest(): Request {
        return request.header("Origin", "https://leetcode.com")
            .header(
                "User-Agent",
                "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1"
            )
    }

    private suspend fun token(title: String): String {
        val page = "https://leetcode.com/problems/$title/"
        val (_, response, _) = page.httpGet()
            .wrapRequest()
            .awaitStringResponseResult()
        val cookie = response.header("Set-Cookie").first()
        return "csrftoken=(\\w+);".toRegex().find(cookie)?.groupValues?.getOrNull(1)
            ?: throw  IllegalStateException("get token failed")
    }

    suspend fun problem(title: String): Problem {
        val token = token(title)

        return "https://leetcode.com/graphql".httpPost()
            .wrapRequest()
            .header("Referer", "https://leetcode.com/problems/$title/")
            .header("x-csrftoken", token)
            .header("Cookie", "csrftoken=$token;")
            .jsonBody(ProblemGraphQuery(title))
//            .also { println(it) }
            .awaitObject(ProblemDeserializer())

    }

    suspend fun problemById(id: String): Problem {
        val map = "https://leetcode.com/api/problems/all/".httpGet()
            .wrapRequest()
            .awaitObject(jsonDeserializer())
            .obj()
            .getJSONArray("stat_status_pairs")
            .map {
                (it as JSONObject).getJSONObject("stat")
                    .run { getInt("question_id").toString() to optString("question__title_slug") }
            }
            .toMap()
            .filterValues { it.isNullOrBlank().not() }

        return map[id]?.let { problem(it) } ?: throw IllegalArgumentException("Problem #$id not found!")
    }
}


