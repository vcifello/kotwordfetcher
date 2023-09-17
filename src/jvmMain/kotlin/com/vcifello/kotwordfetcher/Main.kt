package com.vcifello.kotwordfetcher

//import com.soywiz.klock.*
import com.vcifello.kotwordfetcher.sources.Formats
import com.vcifello.kotwordfetcher.sources.Sources
import kotlinx.datetime.LocalDate
import java.io.File
import kotlin.system.exitProcess


suspend fun main() {
    println("What's your name?")
    val name = readln()
    println("Hello, $name!")


    var fetcher = Fetcher("1wohJzZLHovwg1UYaXzEXaGI.hYg1hdkH.BvY0Qc8yXC8ifQLFKflZTlJZj4VgIqFBjOoea6bgYnRxckKfk3fLpwyGx9OToAy29WWK3c3XEgatAPH6yIz0L3xDTQO38FS1^^^^CBQSLwjNmOqmBhDKoOqmBhoSMS35FtILBIFlAXAm1JKbKJx_IN65wR8qAgACONeglv0EGkBvS6eRY1RKeW0qMXFM7kG6QK1av-2H1AqazZ0n7K29gQpGDOmPeCuJ5PLqTz9otisO2zF5KRAbeTXOxewhJ5sI")


    println(fetcher.getMapOfSources())

    val inputDate = "2023-08-20"
    val pd = LocalDate.parse(inputDate)
    val ds  = pd.toString()

    println(ds)

    println(Formats.PDF.format)
    println(Formats.PDF.name)
    val (bytes, filename) = fetcher.getPuzzleAsBytes(pd, Formats.PDF, Sources.NEWYORKTIMESDAILY )
    println(filename)
    println(bytes.size)
    File("${filename}.${Formats.PDF.format}").writeBytes(bytes)


//
//    print(Fetcher.getMapOfSources())
//
//    val inputDate = "2023-08-20"
//    val pd = LocalDate.parse(inputDate)
//    val ds  = pd.toString()
//    println(ds)
//
//    //val dateFormat = DateFormat("yyyy-MM-dd")
//    //val pd = dateFormat.parseDate(inputDate)
//    //val isoDate = pd.format(ISO8601.DATE_CALENDAR_COMPLETE)
//
//
//    val (bytes, filename) = Fetcher.getPuzzleAsBytes(pd, Formats.PDF, Sources.NEWYORKTIMESDAILY )
//    println(filename)
//    println(bytes.size)
//    File("${filename}.pdf").writeBytes(bytes)

}