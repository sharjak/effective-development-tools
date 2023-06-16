plugins {
    id("java")
    id("org.springframework.boot") version "3.1.0"
    id("io.freefair.lombok") version "8.0.1"
}

group = "org.recipes"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":app-main"))
}

springBoot {
    mainClass.set("org.recipes.RecipesApi")
}

allprojects {
    repositories {
        mavenCentral()
    }
    apply(plugin = "java-library")
    apply(plugin = "io.freefair.lombok")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
}