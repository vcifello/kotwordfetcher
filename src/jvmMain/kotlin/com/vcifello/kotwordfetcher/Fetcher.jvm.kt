package com.vcifello.kotwordfetcher

actual class Fetcher private actual constructor() : FetcherBase() {

    constructor(nyts: String) : this() {
        nytsToken = nyts
    }
}
