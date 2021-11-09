import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    id("org.springframework.boot") version "2.3.0.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") version "1.4.20"
    kotlin("plugin.spring") version "1.4.20"
    id("com.google.cloud.tools.jib") version "2.6.0"
}

group = "com.ort"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

sourceSets {
    getByName("main").java.srcDirs("src/main/kotlin")
    getByName("test").java.srcDirs("src/test")
    getByName("main").resources.srcDirs("src/main/resources")
    getByName("test").resources.srcDirs("src/test/resources")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    // dbflute
    implementation("org.springframework.boot:spring-boot-starter-data-jpa") {
        exclude("com.zaxxer:HikariCP")
    }
    implementation("org.apache.tomcat:tomcat-jdbc:9.0.10")
    implementation("org.dbflute:dbflute-runtime:1.2.1")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    // mysql
    val mysqlConnectorVersion = if (System.getenv("MYSQL_CONNECTOR_VERSION") != null) {
        System.getenv("MYSQL_CONNECTOR_VERSION")
    } else "8.0.25"
    implementation("mysql:mysql-connector-java:$mysqlConnectorVersion")
    // jwt
    implementation("io.jsonwebtoken:jjwt-api:0.10.7")
    implementation("io.jsonwebtoken:jjwt-impl:0.10.7")
    implementation("io.jsonwebtoken:jjwt-jackson:0.10.7")
    implementation("com.google.firebase:firebase-admin:6.8.1")
    // twitter
    implementation("org.twitter4j:twitter4j-core:4.0.7")
    // slack
    implementation("com.slack.api:slack-api-client:1.4.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // mockito
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

jib {
    from {
        image = "arm64v8/openjdk:8"
        platforms {
            platform {
                architecture = "arm64"
                os = "linux"
            }
        }
    }
    to {
        image = "ghcr.io/h-orito/howling-wolf"
    }
    container {
        jvmFlags = listOf(
            "-server",
            "-Djava.awt.headless=true",
            "-Dspring.profiles.active=production"
        )
        creationTime = "USE_CURRENT_TIMESTAMP"
    }
}
