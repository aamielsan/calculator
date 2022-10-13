plugins {
    id("com.company.kotlin-app")
}

dependencies {
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("ch.qos.logback:logback-classic:1.4.3")
    implementation("ch.qos.logback:logback-core:1.4.3")

    implementation("software.amazon.awscdk:core:1.176.0")
    implementation("software.amazon.awscdk:sqs:1.139.0")
}

application {
    mainClass.set("com.company.infra.MainKt")
}
