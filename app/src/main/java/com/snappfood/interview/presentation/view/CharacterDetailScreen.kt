package com.snappfood.interview.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.snappfood.interview.data.api.ApiResult
import com.snappfood.interview.data.model.CharacterDetail
import com.snappfood.interview.presentation.view.composable.DetailRow
import com.snappfood.interview.presentation.viewmodel.CharacterDetailViewModel

@Composable
fun CharacterDetailScreen(viewModel: CharacterDetailViewModel, characterUrl: String) {
    val characterDetailState by viewModel.characterDetail.collectAsState()

    if (characterDetailState is ApiResult.Empty) {
        viewModel.getCharacterDetail(characterUrl)
    }

    Spacer(modifier = Modifier.padding(16.dp))

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        item {
            when (characterDetailState) {
                is ApiResult.Loading -> {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                }

                is ApiResult.Success -> {
                    val characterDetail =
                        (characterDetailState as ApiResult.Success<CharacterDetail>).data
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = characterDetail.name,
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Black
                        )
                        HorizontalDivider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp),
                            color = Color.Black
                        )
                        DetailRow(
                            label = "Height",
                            value = "${characterDetail.height}cm (${
                                convertToFeetInches(characterDetail.height.toInt())
                            })"
                        )
                        DetailRow(label = "Mass", value = characterDetail.mass)
                        DetailRow(label = "Hair Color", value = characterDetail.hair_color)
                        DetailRow(label = "Skin Color", value = characterDetail.skin_color)
                        DetailRow(label = "Eye Color", value = characterDetail.eye_color)
                        DetailRow(label = "Birth Year", value = characterDetail.birth_year)
                        DetailRow(label = "Gender", value = characterDetail.gender)
                        DetailRow(label = "Homeworld", value = characterDetail.homeworld)
                        DetailRow(label = "Films", value = characterDetail.films.joinToString())
                        DetailRow(label = "Species", value = characterDetail.species.joinToString())
                        DetailRow(
                            label = "Vehicles",
                            value = characterDetail.vehicles.joinToString()
                        )
                        DetailRow(
                            label = "Starships",
                            value = characterDetail.starships.joinToString()
                        )
                        DetailRow(label = "Created", value = characterDetail.created)
                        DetailRow(label = "Edited", value = characterDetail.edited)
                        DetailRow(label = "URL", value = characterDetail.url)
                    }
                }

                is ApiResult.Error -> {
                    val error = (characterDetailState as ApiResult.Error)
                    Text(
                        "${error.message}: ${error.cause}",
                        color = Color.Red,
                    )
                }

                ApiResult.Empty -> Unit
            }
        }
    }
}

fun convertToFeetInches(cm: Int): String {
    val totalInches = (cm * 0.393701).toInt()
    val feet = totalInches / 12
    val inches = totalInches % 12
    return "$feet' $inches\""
}