package com.company.calculator

import com.company.calculator.routes.calculateRoute
import com.company.calculator.routes.healthCheckRoute
import org.http4k.contract.contract
import org.http4k.contract.openapi.ApiInfo
import org.http4k.contract.openapi.v3.OpenApi3
import org.http4k.contract.openapi.v3.OpenApi3ApiRenderer
import org.http4k.core.HttpHandler
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters
import org.http4k.format.KotlinxSerialization
import org.http4k.routing.bind
import org.http4k.routing.routes

fun calculatorApp(): HttpHandler {
    val contract = contract {
        renderer = OpenApi3(
            apiInfo = ApiInfo("Calculator API", "v1.0"),
            json = KotlinxSerialization,
            extensions = emptyList(),
            apiRenderer = OpenApi3ApiRenderer(KotlinxSerialization)
        )
        descriptionPath = "/swagger.json"
        routes += calculateRoute()
        routes += healthCheckRoute()
    }

    return DebuggingFilters.PrintRequestAndResponse()
            .then(routes("/api/v1" bind contract))
}
