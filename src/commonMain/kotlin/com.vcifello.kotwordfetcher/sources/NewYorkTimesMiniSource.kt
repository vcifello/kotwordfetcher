package com.vcifello.kotwordfetcher.sources

import com.jeffpdavidson.kotwords.model.Puzzle
import kotlinx.datetime.LocalDate

//import com.soywiz.klock.Date

object NewYorkTimesMiniSource : NewYorkTimesBaseSource() {

    override val sourceName = "New York Times Mini"
    override val sourceKey = Sources.NEWYORKTIMESMINI
    override val stream = "mini"

    override suspend fun getPuzzle(puzzleDate: LocalDate): Puzzle {
        return getPuzzle(puzzleDate, stream)
    }

}