plugins {
    id("java")
}

group = "com.bielecki"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("commons-io:commons-io:2.11.0")
    implementation("org.apache.commons:commons-vfs2:2.9.0")


    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")


}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}