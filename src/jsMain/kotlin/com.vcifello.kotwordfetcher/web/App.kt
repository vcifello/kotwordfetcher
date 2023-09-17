package com.vcifello.kotwordfetcher.web

import com.vcifello.kotwordfetcher.Fetcher
import com.vcifello.kotwordfetcher.sources.Formats
import com.vcifello.kotwordfetcher.sources.Sources
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

fun main(){
    console.log("Hello, Kotlin/JS")

    var fetcher1 = Fetcher("nyts string", "anticors")


}

@OptIn(ExperimentalJsExport::class)
@JsExport
fun doit(){

    val mainScope = MainScope()


    println("I just called a function!!!")

    mainScope.launch {

//        val junk = Fetcher.getInfo()
//        println(junk)

        val fetcher = Fetcher("1wohJzZLHovwg1UYaXzEXaGI.hYg1hdkH.BvY0Qc8yXC8ifQLFKflZTlJZj4VgIqFBjOoea6bgYnRxckKfk3fLpwyGx9OToAy29WWK3c3XEgatAPH6yIz0L3xDTQO38FS1^^^^CBQSLwjNmOqmBhDKoOqmBhoSMS35FtILBIFlAXAm1JKbKJx_IN65wR8qAgACONeglv0EGkBvS6eRY1RKeW0qMXFM7kG6QK1av-2H1AqazZ0n7K29gQpGDOmPeCuJ5PLqTz9otisO2zF5KRAbeTXOxewhJ5sI",
            "https://proxy.cors.sh/")
        val ld = kotlinx.datetime.LocalDate(2023, 8, 2)
        val (bytes, filename) = fetcher.getPuzzleAsBytes(ld ,Formats.PUZ,Sources.NEWYORKTIMESDAILY)
        println(filename)
        println(bytes.size)

    }


}