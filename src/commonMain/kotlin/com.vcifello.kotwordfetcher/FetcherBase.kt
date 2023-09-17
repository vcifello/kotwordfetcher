package com.vcifello.kotwordfetcher

import com.jeffpdavidson.kotwords.model.Puzzle
import com.vcifello.kotwordfetcher.sources.Formats
import com.vcifello.kotwordfetcher.sources.NewYorkTimesDailySource
import com.vcifello.kotwordfetcher.sources.NewYorkTimesMiniSource
import com.vcifello.kotwordfetcher.sources.Sources
import kotlinx.datetime.LocalDate


//https://stackoverflow.com/questions/69323718/kotlin-multiplatform-expect-actual-class-some-methods-shared


abstract class FetcherBase {

    private val SOURCES = listOf(
//        AmuseLabsSource,
//        BostonGlobeSource,
//        CrosshareSource,
//        CrosswordCompilerSource,
//        CrosswordNexusSource,
        NewYorkTimesDailySource,
        NewYorkTimesMiniSource,
//        PuzzleSocietySource,
//        TheWeekSource,
//        UniversalSource,
//        WallStreetJournalSource,
//        WorldOfCrosswordsSource,
//        XWordInfoSource,
//
//        // Prefer extracted puzzles from applets to .puz files, which tend to be more constrained.
//        PuzzleLinkSource,
    )

    fun getMapOfSources() : Map<String,String>
    {
        val sourceMap = mutableMapOf<String, String>()

        SOURCES.forEach{ source ->
            sourceMap.put(source.sourceKey.keyName,source.sourceName)
        }

        return sourceMap
    }

    // bytes, filename = downloader.getbytes(puzFormat,puzDate,puzOutlet)

    suspend fun getPuzzleAsBytes(
        puzDate: LocalDate,
        puzFormat: Formats,
        puzSource: Sources
    ) : Pair<ByteArray, String>
    {
        val (puzzle, baseFileName) = getPuzzleFromSource(puzDate,puzSource)

        val bytes = convertPuzzle(puzzle, puzFormat)

        return bytes to baseFileName
    }

    private suspend fun getPuzzleFromSource(puzDate: LocalDate, puzSource: Sources) : Pair<Puzzle, String>
    {
        val src = SOURCES.find { src -> src.matchesKey(puzSource)}

        val puzzle = src!!.getPuzzle(puzDate)

        val baseFileName = getBaseFilename(puzzle) ?: src.sourceName

        return puzzle to baseFileName
    }

    private fun getBaseFilename(puzzle: Puzzle): String? {
        // In descending priority, author-title, title, author, scraping source.
        // Each word is capitalized, and non-alphanumeric characters are removed.
        val puzzleTitle = puzzle.title
        val puzzleAuthor = puzzle.creator
        val fileTitleParts = listOf(puzzleAuthor, puzzleTitle).filterNot { it.isEmpty() }
        return if (fileTitleParts.isEmpty()) {
            null
        } else {
            val cleanedText =fileTitleParts.joinToString("-")
            cleanedText.split("\\s+".toRegex()).joinToString("") {
                it.replace("[^A-Za-z0-9-]".toRegex(), "").replaceFirstChar { ch -> ch.uppercase() }
            }
        }
    }

    private suspend fun convertPuzzle(puzzle: Puzzle, puzFormat: Formats) : ByteArray
    {
        return when (puzFormat) {

            Formats.PUZ -> puzzle.asAcrossLiteBinary()
            Formats.PDF -> puzzle.asPdf()
            Formats.JPUZ -> puzzle.asJpzFile()
            Formats.IPUZ -> puzzle.asIpuzFile()

        }
    }
}