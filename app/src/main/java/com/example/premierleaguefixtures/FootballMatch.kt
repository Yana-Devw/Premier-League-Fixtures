package com.example.premierleaguefixtures

data class FootballMatch(var teamFirstGoals: Int = 0, var teamSecondGoals: Int = 0) {

    fun setGoals(teamFirst: Int, teamSecond: Int) {
        if (teamFirst >= 0 && teamSecond >= 0) {
            teamFirstGoals = teamFirst
            teamSecondGoals = teamSecond
        }
    }
}

fun main() {
    val matches = Array(10) { FootballMatch() }

    matches.forEach {
            match -> match.setGoals((0..5).random(), (0..5).random())
    }

    println("All matches:")
    matches.forEach { println(it) }

    val nonDrawMatches = matches.filter { it.teamFirstGoals != it.teamSecondGoals }

    println("Matches without draws:")
    nonDrawMatches.forEach { println(it) }

    val maxGoalDifference = nonDrawMatches.maxOfOrNull { kotlin.math.abs(it.teamFirstGoals - it.teamSecondGoals) } ?: 0
    val maxDifferenceMatches = nonDrawMatches.filter { kotlin.math.abs(it.teamFirstGoals - it.teamSecondGoals) == maxGoalDifference }.toSet()

    println("Max goal difference: $maxGoalDifference")
    println("Matches with max goal difference:")
    maxDifferenceMatches.forEach { println(it) }
}
