package com.vcifello.kotwordfetcher

actual class Fetcher private actual constructor() : FetcherBase() {

    constructor(nyts: String, antiCors: String) : this() {
        nytsToken = nyts
        corsAvoider = antiCors
    }
}

