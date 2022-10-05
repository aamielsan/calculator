package com.company.calculator.api

import kotlinx.serialization.Serializable

@Serializable
data class CalculateResponse(
    val data: Double?,
)