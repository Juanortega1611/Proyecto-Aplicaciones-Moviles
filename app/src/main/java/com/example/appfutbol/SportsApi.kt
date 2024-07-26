package com.example.appfutbol

import retrofit2.Call
import retrofit2.http.Query
import retrofit2.http.GET


interface SportsApi {
    @GET("search_all_teams.php")
    fun searchAllTeams(@Query ("s") sport: String,
                       @Query("c") country: String):
                       Call<ApiResponse>
    @GET("lookuptable.php")
    fun getLeagueTable(@Query("l") leagueId: String):
                       Call<LeagueTableResponse>
}