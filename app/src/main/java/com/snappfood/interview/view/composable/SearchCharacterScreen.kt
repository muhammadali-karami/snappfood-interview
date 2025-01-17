package com.snappfood.interview.view.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.snappfood.interview.data.api.ApiResult
import com.snappfood.interview.data.model.CharacterDetail
import com.snappfood.interview.viewmodel.SearchCharacterViewModel
import kotlinx.coroutines.delay

@Composable
fun SearchCharacterScreen(
    viewModel: SearchCharacterViewModel,
    onCharacterSelected: (CharacterDetail) -> Unit
) {
    var query by rememberSaveable { mutableStateOf("") }
//    var debounceQuery by rememberSaveable { mutableStateOf("") }
    val charactersState by viewModel.characters.collectAsState()

//    LaunchedEffect(query) {
//        delay(300)
//        if (query == debounceQuery) {
//            viewModel.searchCharacterWithDebounce(query)
//        }
//    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = query,
                onValueChange = {
                    query = it
                    viewModel.searchCharacterWithDebounce(it)
                },
                label = { Text("Search your character") }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (charactersState) {
            is ApiResult.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            is ApiResult.Success -> {
                val characterList =
                    (charactersState as ApiResult.Success<List<CharacterDetail>>).data
                if (characterList.isEmpty()) {
                    Text(
                        text = "No characters found. Try searching!",
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        color = Color.Gray
                    )
                } else {
                    LazyColumn {
                        items(characterList) { character ->
                            CharacterRow(character, onCharacterSelected)
                        }
                    }
                }
            }

            is ApiResult.Error -> {
                val errorMessage = (charactersState as ApiResult.Error).message
                Text("Error: $errorMessage", color = Color.Red, modifier = Modifier.padding(16.dp))
            }

            ApiResult.Empty -> Unit
        }
    }
}