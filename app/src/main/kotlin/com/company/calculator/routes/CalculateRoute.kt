package com.company.calculator.routes

import com.company.calculator.api.CalculateRequest
import com.company.calculator.api.CalculateResponse
import com.company.calculator.domain.add
import com.company.calculator.domain.divide
import com.company.calculator.domain.multiply
import com.company.calculator.domain.subtract
import org.http4k.contract.ContractRoute
import org.http4k.contract.meta
import org.http4k.contract.security.ApiKeySecurity
import org.http4k.core.Body
import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.core.with
import org.http4k.format.KotlinxSerialization.auto
import org.http4k.lens.Header
import org.http4k.lens.nonEmptyString

private class Resource

private val apiKey = Resource::class.java.getResource("/apikey.txt")?.readText(Charsets.UTF_8)
    ?: throw IllegalStateException("File not found")

fun calculateRoute(): ContractRoute {
    val apiSecurity = ApiKeySecurity(Header.nonEmptyString().required("x-api-key"), { it == apiKey })
    val requestBody = Body.auto<CalculateRequest>().toLens()
    val responseBody = Body.auto<CalculateResponse>().toLens()

    val spec = "/calculate" meta {
        security = apiSecurity
        summary = "Calculates the result for the given operation"
        receiving(requestBody to CalculateRequest(1.0, 2.0, "ADD"))
        returning(Status.OK, responseBody to CalculateResponse(3.0))
    } bindContract Method.POST

    val calculate: HttpHandler = { request: Request ->
        val body: CalculateRequest = requestBody(request)
        val result: Double? = when (body.operation) {
            "ADD" -> add(body.x, body.y)
            "SUBTRACT" -> subtract(body.x, body.y)
            "MULTIPLY" -> multiply(body.x, body.y)
            "DIVIDE" -> divide(body.x, body.y)
            else -> null
        }
        Response(Status.OK)
            .with(responseBody of CalculateResponse(data = result))
    }

    return spec to calculate
}