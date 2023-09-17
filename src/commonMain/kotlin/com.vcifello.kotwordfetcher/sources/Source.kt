package com.vcifello.kotwordfetcher.sources

import com.jeffpdavidson.kotwords.model.Puzzle
import kotlinx.datetime.LocalDate

//import com.soywiz.klock.Date

/** Source of puzzles that can be downloaded. */
interface Source {

    val sourceName: String

    val sourceKey: Sources

    fun matchesKey(key: Sources): Boolean
    {
        return key == sourceKey
    }

    suspend fun getPuzzle(puzzleDate: LocalDate) : Puzzle

}