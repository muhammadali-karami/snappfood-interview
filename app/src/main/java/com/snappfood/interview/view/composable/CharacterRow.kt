package com.snappfood.interview.view.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.snappfood.interview.data.model.CharacterDetailResponse

@Composable
fun CharacterRow(
    characterDetailResponse: CharacterDetailResponse,
    onCharacterSelected: (CharacterDetailResponse) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCharacterSelected(characterDetailResponse) }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .defaultMinSize(minHeight = 32.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = characterDetailResponse.name,
                color = Color.Black,
            )
        }
    }
}