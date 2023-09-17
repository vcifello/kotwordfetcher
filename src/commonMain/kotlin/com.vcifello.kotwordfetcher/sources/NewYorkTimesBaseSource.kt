package com.vcifello.kotwordfetcher.sources

import com.vcifello.kotwordfetcher.Http
import com.jeffpdavidson.kotwords.formats.NewYorkTimes
import com.jeffpdavidson.kotwords.model.Puzzle
import com.vcifello.kotwordfetcher.nytsToken
import kotlinx.datetime.LocalDate

//import com.soywiz.klock.Date
//import com.soywiz.klock.ISO8601

abstract class NewYorkTimesBaseSource : Source {


    //var nytToken = configToken

    abstract val stream: String

    suspend fun getPuzzle(puzzleDate: LocalDate, stream: String) : Puzzle
    {

        val nytUrl = "https://www.nytimes.com/svc/crosswords/v6/puzzle/$stream/$puzzleDate.json"
        //val apiUrl = "https://nyt-games-prd.appspot.com/svc/crosswords/v6/puzzle/$stream/$puzzleDate.json"
        //val apiUrl = "https://api.spacexdata.com/v5/launches"

        val puzzleJson = Http.fetchAsString(nytUrl, listOf("nyt-s" to nytsToken))

        return NewYorkTimes.fromApiJson(puzzleJson, stream).asPuzzle()

    }

    suspend fun getInfo(): String
    {
        val apiUrl = "https://api.spacexdata.com/v5/launches"
        val puzzleJson = Http.fetchAsString(apiUrl, listOf())

        return puzzleJson


    }
}