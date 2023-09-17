package com.vcifello.kotwordfetcher.sources

import com.jeffpdavidson.kotwords.model.Puzzle
//import com.soywiz.klock.Date
import kotlinx.datetime.LocalDate

object NewYorkTimesDailySource : NewYorkTimesBaseSource() {

    override val sourceName = "New York Times Daily"
    override val sourceKey = Sources.NEWYORKTIMESDAILY
    override val stream = "daily"

    override suspend fun getPuzzle(puzzleDate: LocalDate) : Puzzle
    {
        return getPuzzle(puzzleDate, stream)
    }

}