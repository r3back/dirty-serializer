plugins {
    java
    `java-library`
    `maven-publish`
    id ("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "com.github.r3back"
version = "0.0.1"

val copyJars = {
        file: Provider<RegularFile> -> run {
        val name = file.get().asFile.name

        val folder = rootProject.rootDir.absolutePath

        val path = "$folder/generated/$name"

        file.get().asFile.copyTo(File(path), true)
    }
}

project.extra["copyJars"] = copyJars

subprojects{
    apply(plugin = "java")
    apply(plugin = "maven-publish")
    apply(plugin = "com.github.johnrengelman.shadow")

    repositories {
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }
    }

    dependencies {
        compileOnly("org.projectlombok:lombok:1.18.22")
        annotationProcessor("org.projectlombok:lombok:1.18.22")
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
}

