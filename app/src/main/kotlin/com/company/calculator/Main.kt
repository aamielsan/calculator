package com.company.calculator

import org.slf4j.LoggerFactory

fun main() {
    val logger = LoggerFactory.getLogger("Main")
    val port = 8001
    val server = calculatorServer(port)
    server.start()
    logger.info("Server started. Listening at port $port")
}
