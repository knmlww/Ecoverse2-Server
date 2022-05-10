plugins {
    java
    id("org.springframework.boot") version "2.6.7"

}

group = "com.example.demo"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()

}

val shade: Configuration = configurations.create("shade")

dependencies {


    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-security")
    val springVersion = "2.6.7"
    implementation ("org.springframework.boot:spring-boot-starter-web:2.6.7")
    implementation ("org.springframework.boot:spring-boot-starter-web-services:$springVersion")
    implementation ("org.springframework.boot:spring-boot-starter-websocket:$springVersion")
    implementation ("org.springframework.boot:spring-boot-starter-test:$springVersion")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:9.0.62")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.2")
    implementation("org.springframework:spring-jdbc:5.2.2.RELEASE")
    implementation("org.mariadb.jdbc:mariadb-java-client:2.0.3")
    implementation("mysql:mysql-connector-java:8.0.28")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
    implementation("org.projectlombok:lombok:1.18.10")
    implementation ("org.springframework.boot:spring-boot-starter-security:2.6.7")
    implementation ("org.thymeleaf.extras:thymeleaf-extras-springsecurity5:3.0.4.RELEASE")
    implementation("com.google.protobuf:protobuf-java:3.14.0");



















//    implementation(shade)
}

tasks {
    getByName<Jar>("jar") {
        from(shade.map { if (it.isDirectory) { it } else { zipTree(it) } }) {
            exclude("META-INF/*.SF")
            exclude("META-INF/*.DSA")
            exclude("META-INF/*.RSA")
        }
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
}
