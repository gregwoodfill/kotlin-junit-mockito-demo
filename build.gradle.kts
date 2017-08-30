buildscript {
    repositories {
        maven {
            setUrl("https://plugins.gradle.org/m2/")
            jcenter()
        }
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.5.6.RELEASE")
        classpath("org.jetbrains.kotlin:kotlin-allopen:1.1.4-2")

    }
}

apply {
    plugin("org.springframework.boot")
    plugin("org.jetbrains.kotlin.plugin.spring")
}


plugins {
    kotlin(module = "jvm", version = "1.1.4-2")
    idea
    java
    application
}

ext["mockito.version"] = "2.9.0"

dependencies {
    compile(kotlin("stdlib-jre8"))
    compile(kotlin("reflect"))
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("com.fasterxml.jackson.datatype:jackson-datatype-jsr310") // java time
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.8.7") // kotlin data classes
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.8.7")
    compile("com.nhaarman:mockito-kotlin:1.5.0")
    testCompile("org.amshove.kluent:kluent:1.+")
    testCompile("org.springframework.boot:spring-boot-starter-test")
    compile("com.gregwoodfill.assert:kotlin-json-assert:0.1.0")
}

repositories {
    jcenter()
    maven {
        setUrl("https://dl.bintray.com/gregwoodfill/maven")
    }
}