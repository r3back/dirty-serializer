plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = rootProject.group
version = rootProject.version

dependencies {
    implementation(project(":dirty-api"))

    implementation("junit:junit:4.13.2")

    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.mockito:mockito-core:5.3.1")
    testImplementation("org.mockito:mockito-junit-jupiter:5.3.1")
}

tasks {
    shadowJar {
        archiveFileName.set("dirty-core.jar")
        archiveClassifier.set("dirty-core-classifier")

        relocate("com.rabbitmq", "com.qualityplus.dirtymessaging.base.lib.rabbitmq")

        doLast {
            @Suppress("UNCHECKED_CAST")
            (rootProject.ext.get("copyJars") as? ((Provider<RegularFile>) -> File) ?: return@doLast)(archiveFile)
        }
    }

    build {
        dependsOn(shadowJar)
    }
}

publishing {
    publications {
        register<MavenPublication>("maven") {
            groupId = project.group.toString()
            version = project.version.toString()
            artifactId = rootProject.name

            artifact(project.tasks.shadowJar.get().archiveFile)
        }
    }

    publishing {
        repositories {
            maven {
                name = "jitpack"
                url = uri("https://jitpack.io")
                credentials {
                    username = System.getenv("JITPACK_USERNAME")
                    password = System.getenv("JITPACK_PASSWORD")
                }
            }
        }
    }
}