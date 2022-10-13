package com.company.infra

import software.amazon.awscdk.core.App

fun main() {
    val app = App()
    AppStack(app, "ApplicationStack")

    app.synth()
}
