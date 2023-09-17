# Kotword Fetcher
Multiplatform library to fetch puzzles.

Uses ktor clients to fetch puzzle sources and convert them into the desired formats with the **absolutely amazing** [kotwords](https://github.com/jpd236/kotwords) library.

This was part of an attempt to learn about programming and kotlin. Most importantly, this provides my wife with NYT Daily puzzles delivered to her doorstep in puz format.

## Constructors

- nyt-s tokens are required
- js library requires workaround for CORS

The constructors require these values to be passed in.  

This allowed learning about expected/actual, inheritance, and multiplatform development.

## TODO
- add sources

## Alternative to JS component

Web API with ktor server wrapping the JVM component.

- no CORS issues upon fetching
- any platform or language can access the web api
- can create sdk in common of multiplatform project
- web api can be dockerized 
- can serve SPA

