package com.example.appfutbol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appfutbol.ui.theme.AppFutbolTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppFutbolTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    ClasificacionLiga()
                }
            }
        }
    }
}

@Composable
fun ClasificacionLiga() {
    var leagueTable by remember { mutableStateOf<List<LeaguePosition>?> (null)}
    var error by remember { mutableStateOf <String?>(null)}

    LaunchedEffect(Unit) {

        val apiService = ApiClient.getClient().create(SportsApi::class.java)
        val call = apiService.getLeagueTable(leagueId = "4335") // Ajusta el ID de la liga según sea necesario

        call.enqueue(object : Callback<LeagueTableResponse> {
            override fun onResponse(call: Call<LeagueTableResponse>, response: Response<LeagueTableResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    leagueTable = response.body()?.table
                } else {
                    error = "Error: ${response.message()}"
                }
            }

            override fun onFailure(call: Call<LeagueTableResponse>, t: Throwable) {
                error = "Error: ${t.message}"
            }
        })
    }

    if (leagueTable != null) {
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(leagueTable!!) { position ->
                Text(
                    text = "${position.rank} . ${position.teamName} . ${position.points} . ${position.goalsFor}",
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    } else if (error != null) {
        Text(
            text = error!!,
            modifier = Modifier.padding(16.dp)
        )
    } else {
        Text(text = "Loading", modifier = Modifier.padding(16.dp))
    }
}
