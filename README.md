# Dirty Serializer
Easy to use serialization library, built using faster-jackson.

[![Java CI with Gradle](https://github.com/r3back/dirty-serializer/actions/workflows/gradle.yml/badge.svg)](https://github.com/r3back/dirty-serializer/actions/workflows/gradle.yml)
[![](https://jitpack.io/v/r3back/dirty-serializer.svg)](https://jitpack.io/#r3back/dirty-serializer)

## Dependency Usage

### Maven

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

```xml
<dependency>
    <groupId>com.github.r3back</groupId>
    <artifactId>dirty-serializer</artifactId>
    <version>LATEST</version>
</dependency>
```

### Gradle

```groovy
repositories {
    maven { 
        url 'https://jitpack.io' 
    }
}
```

```groovy
dependencies {
    compileOnly 'com.github.r3back:dirty-serializer:LATEST'
}
```

## Building
Dirty-Serialization uses Gradle to handle dependencies & building.

## Used Tools
* [FasterXML-Jackson](https://github.com/FasterXML/jackson) used to serialize/deserialize.
