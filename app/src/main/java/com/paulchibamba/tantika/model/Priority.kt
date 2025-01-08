package com.paulchibamba.tantika.model


import androidx.compose.ui.graphics.Color
import com.paulchibamba.tantika.ui.theme.HighPriorityColor
import com.paulchibamba.tantika.ui.theme.LowPriorityColor
import com.paulchibamba.tantika.ui.theme.MediumPriorityColor
import com.paulchibamba.tantika.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}