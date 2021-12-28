import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    application
}

group = "dev.galacticraft"
version = "0.0.0"
application.mainClass.set("dev.galacticraft.capes.CapesLauncherKt")

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    val javalinVersion = "4.1.1"
    implementation("io.javalin:javalin:$javalinVersion")

    val exposedVersion = "0.37.2"
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")

    val junitVersion = "5.8.1"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("PASSED", "FAILED", "SKIPPED")
    }
}

tasks.withType<KotlinCompile> {
    sourceCompatibility = "11"
    targetCompatibility = "11"
}