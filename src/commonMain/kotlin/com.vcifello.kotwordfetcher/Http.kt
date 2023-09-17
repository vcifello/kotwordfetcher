package com.vcifello.kotwordfetcher

//import com.vcifello.kotwordsfetcher.sources.corsAvoider
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlin.reflect.typeOf

expect fun httpClient(config: HttpClientConfig<*>.() -> Unit = {}): HttpClient

object Http {

    /** Exception thrown when a fetch fails (e.g. due to a network error or non-200 HTTP response code). */
    class HttpException(message: String) :  Exception(message)

    suspend fun fetchAsString(url: String, myHeaders: List<Pair<String, String>>) : String {

        var urlToFetch = url
        val client = httpClient()
        if (client.engine::class.simpleName == "JsClientEngine") {
            urlToFetch =  corsAvoider + url
        }

        val response: HttpResponse = client.request(urlToFetch) {
            method = HttpMethod.Get
            myHeaders.forEach { (key, value) ->
                headers.append(key, value)
            }

            //antiCORS "https://proxy.cors.sh/"
            //https://cors.sh/
            headers.append("x-cors-api-key","temp_63dee014d7c42c8c80f684a229d33869")
        }

        if (response.status != HttpStatusCode.OK) {
            throw HttpException("HTTP GET error code ${response.status} from URL: $url")
        }

        return response.bodyAsText()
    }
}
