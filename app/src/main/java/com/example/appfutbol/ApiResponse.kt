package com.example.appfutbol

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("teams")
    val teams : List<Team>
)

data class LeagueTableResponse(
    @SerializedName("table")
    val table : List<LeaguePosition>
)

data class Team(
    @SerializedName("IdTeam")
    val idTeam: String,
    @SerializedName("strTeam")
    val name: String,
    @SerializedName("strStadium")
    val stadium: String,
)


data class LeaguePosition(
    @SerializedName("idStanding")
    val idStanding: String,
    @SerializedName("intRank")
    val rank: Int,
    @SerializedName("idTeam")
    val idTeam: String,
    @SerializedName("idStanding")
    val teamName: String,
    @SerializedName("intRank")
    val teamBadge: String,
    @SerializedName("idStanding")
    val idLeague: String,
    @SerializedName("intRank")
    val leagueName: String,
    @SerializedName("idStanding")
    val season: String,
    @SerializedName("intRank")
    val form: String,
    @SerializedName("idStanding")
    val descriptions: String,
    @SerializedName("intRank")
    val played: Int,
    @SerializedName("idStanding")
    val wins: Int,
    @SerializedName("intRank")
    val losses: Int,
    @SerializedName("idStanding")
    val draws: Int,
    @SerializedName("intRank")
    val goalsFor: Int,
    @SerializedName("idStanding")
    val goalsAgainst: Int,
    @SerializedName("intRank")
    val goalDifference: Int,
    @SerializedName("idStanding")
    val points: Int,
    @SerializedName("intRank")
    val dateUpdated: String,
)