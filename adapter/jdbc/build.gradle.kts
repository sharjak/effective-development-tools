dependencies {
    runtimeOnly("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}