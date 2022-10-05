package com.company.calculator.routes

import org.http4k.contract.ContractRoute
import org.http4k.contract.meta
import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Status

fun healthCheckRoute(): ContractRoute {
    val spec = "/health" meta {
        summary = "Health check endpoint"
        returning(Status.OK)
    } bindContract Method.GET

    return spec to { _ -> Response(Status.OK).body(Status.OK.description) }
}