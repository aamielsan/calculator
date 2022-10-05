package com.company.calculator.api

import kotlinx.serialization.Serializable

@Serializable
data class CalculateRequest(
    val x: Double,
    val y: Double,
    val operation: String,
)