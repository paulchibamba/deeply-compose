package com.paulchibamba.deeply.model

import java.time.LocalDateTime
import kotlin.time.Duration

data class Interruption(
    val timeStamp:LocalDateTime,
    val reason:String,
    val duration: Duration
)
