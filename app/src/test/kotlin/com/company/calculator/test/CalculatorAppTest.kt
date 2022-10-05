package com.company.calculator.test

import com.company.calculator.calculatorApp
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CalculatorAppTest {
    @Test
    fun `given health check request, should return successful response`() {
        val request = Request(Method.GET, "/api/v1/health")
        val app = calculatorApp()
        val response = app(request)
        Assertions.assertEquals(Status.OK, response.status)
    }

    @Test
    fun `given swagger docs request, should return successful response`() {
        val request = Request(Method.GET, "/api/v1/swagger.json")
        val app = calculatorApp()
        val response = app(request)
        Assertions.assertEquals(Status.OK, response.status)
        Assertions.assertNotNull(response.bodyString())
    }

    @Test
    fun `given ADD calculate request, should return successful response`() {
        val request = Request(Method.POST, "/api/v1/calculate")
            .header("x-api-key", "sylvester")
            .body("""
                {
                    "x": 1,
                    "y": 2,
                    "operation": "ADD"
                }
            """.trimIndent())
        val app = calculatorApp()
        val response = app(request)
        Assertions.assertEquals(Status.OK, response.status)
        Assertions.assertEquals("""{"data":3.0}""", response.bodyString())
    }

    @Test
    fun `given SUBTRACT calculate request, should return successful response`() {
        val request = Request(Method.POST, "/api/v1/calculate")
            .header("x-api-key", "sylvester")
            .body("""
                {
                    "x": 1,
                    "y": 2,
                    "operation": "SUBTRACT"
                }
            """.trimIndent())
        val app = calculatorApp()
        val response = app(request)
        Assertions.assertEquals(Status.OK, response.status)
        Assertions.assertEquals("""{"data":-1.0}""", response.bodyString())
    }

    @Test
    fun `given DIVIDE calculate request, should return successful response`() {
        val request = Request(Method.POST, "/api/v1/calculate")
            .header("x-api-key", "sylvester")
            .body("""
                {
                    "x": 1,
                    "y": 2,
                    "operation": "DIVIDE"
                }
            """.trimIndent())
        val app = calculatorApp()
        val response = app(request)
        Assertions.assertEquals(Status.OK, response.status)
        Assertions.assertEquals("""{"data":0.5}""", response.bodyString())
    }

    @Test
    fun `given MULTIPLY calculate request, should return successful response`() {
        val request = Request(Method.POST, "/api/v1/calculate")
            .header("x-api-key", "sylvester")
            .body("""
                {
                    "x": 3,
                    "y": 2,
                    "operation": "MULTIPLY"
                }
            """.trimIndent())
        val app = calculatorApp()
        val response = app(request)
        Assertions.assertEquals(Status.OK, response.status)
        Assertions.assertEquals("""{"data":6.0}""", response.bodyString())
    }
}