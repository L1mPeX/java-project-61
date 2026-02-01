plugins {
    application
    `checkstyle`
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("hexlet.code.App")
}

tasks.getByName<JavaExec>("run") {
    standardInput = System.`in`
}

checkstyle {
    toolVersion = "10.7.0"
    configFile = rootProject.file("config/checkstyle/checkstyle.xml")
    isIgnoreFailures = false
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "hexlet.code.App"
        )
    }
}
