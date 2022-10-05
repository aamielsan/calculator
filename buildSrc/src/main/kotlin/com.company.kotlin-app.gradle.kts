plugins {
    id("com.company.kotlin-common")
    application
}

tasks.jar {
    manifest.attributes["Main-Class"] = application.mainClass.get()
    archiveFileName.set("app.jar")
    val dependencies = configurations
        .runtimeClasspath
        .get()
        .map(::zipTree)
    from(dependencies)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
