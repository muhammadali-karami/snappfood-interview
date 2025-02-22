package com.snappfood.interview.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.snappfood.interview.ui.theme.SnappFoodInterviewTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnappFoodInterviewTheme {
                MaterialTheme {
                    AppNavigation()
                }
            }
        }

        onBackPressedDispatcher.addCallback(this) {
            finish()
        }
    }
}