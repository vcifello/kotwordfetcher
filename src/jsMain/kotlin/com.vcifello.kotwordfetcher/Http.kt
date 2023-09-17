package com.vcifello.kotwordfetcher

import io.ktor.client.*
import io.ktor.client.engine.js.*

actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(Js) {
    config(this)
}