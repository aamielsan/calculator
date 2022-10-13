package com.company.infra

import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.core.Stack

class AppStack(
    scope: Construct,
    id: String,
): Stack(scope, id) {
    init {
        // Put resources part of app stack here

    }
}