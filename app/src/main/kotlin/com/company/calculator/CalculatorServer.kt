package com.company.calculator

import org.http4k.server.Http4kServer
import org.http4k.server.Netty
import org.http4k.server.asServer

fun calculatorServer(port: Int): Http4kServer {
    val app = calculatorApp()
    return app.asServer(Netty(port))
}
