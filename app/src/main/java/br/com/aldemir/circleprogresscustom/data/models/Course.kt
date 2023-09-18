package br.com.aldemir.circleprogresscustom.data.models

import androidx.compose.ui.graphics.Color

data class Course(
    val id: Int,
    val name: String,
    val allClasses: Int,
    val finishedClasses: Int,
    val level: Level,
    val colorMain: Color = Color(0xFF5B7BFE),
    val progressColor: Color = Color.Gray,
    val baseColor: Color = Color.Green,
    val isLightColor: Boolean = false,
)

enum class Level {
    Easy, Medium, Hard,
}