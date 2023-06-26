plugins {
    id("java")
    id("org.springframework.boot") version "3.1.0"
    id("io.freefair.lombok") version "8.0.1"
}

group = "edu.persons"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":app-main"))
}

springBoot {
    mainClass.set("edu.persons.PersonsApi")
}

allprojects {
    repositories {
        mavenCentral()
    }
    apply(plugin = "java-library")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "io.freefair.lombok")
}

subprojects {
    tasks.jar {
        enabled = true
    }

    tasks.bootJar {
        enabled = false
    }

    tasks.bootRun {
        enabled = false
    }

    tasks.bootBuildImage {
        enabled = false
    }
}