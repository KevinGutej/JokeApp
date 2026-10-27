package com.example.jokeapp

import android.app.LocaleManager
import android.os.Bundle
import android.os.LocaleList
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JokeScreen()
                }
            }
        }
    }
}

@Composable
fun JokeScreen() {
    var jokeNumber by remember { mutableIntStateOf(1) }
    val jokes = stringArrayResource(id = R.array.joke_list)
    var jokeIndex by remember { mutableIntStateOf(jokes.indices.random()) }

    val context = LocalContext.current
    val localeManager = context.getSystemService(LocaleManager::class.java)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                localeManager.applicationLocales = LocaleList.getEmptyLocaleList()
            }) {
                Text(text = stringResource(id = R.string.lang_system))
            }
            Button(onClick = {
                localeManager.applicationLocales = LocaleList(Locale("pl"))
            }) {
                Text(text = stringResource(id = R.string.lang_pl))
            }
            Button(onClick = {
                localeManager.applicationLocales = LocaleList(Locale("en"))
            }) {
                Text(text = stringResource(id = R.string.lang_en))
            }
        }

        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Text(
            text = jokes[jokeIndex],
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = {
                jokeNumber++
                jokeIndex = jokes.indices.random()
            },
            shape = CircleShape,
            modifier = Modifier.size(120.dp)
        ) {
            Text(
                text = stringResource(id = R.string.show_joke_btn),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = pluralStringResource(id = R.plurals.jokes_seen, count = jokeNumber, jokeNumber),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        val guestName = stringResource(id = R.string.guest_name)
        Text(
            text = stringResource(id = R.string.greeting, guestName, jokeNumber),
            textAlign = TextAlign.Center
        )
    }
}