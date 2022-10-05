plugins {
    id("com.company.kotlin-app")
}

dependencies {
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("ch.qos.logback:logback-classic:1.4.3")
    implementation("ch.qos.logback:logback-core:1.4.3")

    implementation(platform("org.http4k:http4k-bom:4.32.2.0"))
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-contract")
    implementation("org.http4k:http4k-server-netty")
    implementation("org.http4k:http4k-client-okhttp")
    implementation("org.http4k:http4k-format-kotlinx-serialization")
}

application {
    mainClass.set("com.company.calculator.MainKt")
}
