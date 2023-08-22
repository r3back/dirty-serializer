plugins {
    java
    `java-library`
}

dependencies {
    api("org.slf4j:slf4j-api:2.0.5")
    api("com.fasterxml.jackson.core:jackson-databind:2.14.3")
    api("com.fasterxml.jackson.core:jackson-core:2.14.3")
    api("com.fasterxml.jackson.core:jackson-annotations:2.14.3")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.14.3")
    api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.3")
}

