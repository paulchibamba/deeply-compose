package com.paulchibamba.deeply.model


import androidx.compose.ui.graphics.Color
import com.paulchibamba.deeply.ui.theme.HighPriorityColor
import com.paulchibamba.deeply.ui.theme.LowPriorityColor
import com.paulchibamba.deeply.ui.theme.MediumPriorityColor
import com.paulchibamba.deeply.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}