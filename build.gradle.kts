initVersions(file("project-versions.json"))
plugins {
    id("com.google.devtools.ksp") version "$kotlin_version-1.0.9" apply false
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    extra.apply {
        set("kotlin_version", kotlin_version)
    }

    repositories {
        google()
        maven { setUrl("https://maven.aliyun.com/repository/central") }
        maven { setUrl("https://maven.aliyun.com/repository/jcenter") }
        maven { setUrl("https://maven.aliyun.com/repository/google") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { setUrl("https://maven.aliyun.com/repository/public") }
        //首选国外镜像加快github CI

        mavenCentral()
        maven("https://www.jitpack.io")
        maven("https://maven.aliyun.com/repository/central")
        google { url = uri("https://maven.aliyun.com/repository/google") }
        mavenCentral { url = uri("https://maven.aliyun.com/repository/public") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.2.1")
        classpath(kotlin("gradle-plugin", version = kotlin_version))
        classpath("com.jakewharton:butterknife-gradle-plugin:10.2.3")
        classpath(libs.okhttp)
    }
}

allprojects {
    repositories {
        google()
        //首选国外镜像加快github CI
        maven { setUrl("https://maven.aliyun.com/repository/central") }
        maven { setUrl("https://maven.aliyun.com/repository/jcenter") }
        maven { setUrl("https://maven.aliyun.com/repository/google") }
        maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { setUrl("https://maven.aliyun.com/repository/public") }

        mavenCentral()
        maven("https://www.jitpack.io")
        maven("https://maven.aliyun.com/repository/central")
        google { url = uri("https://maven.aliyun.com/repository/google") }
        mavenCentral { url = uri("https://maven.aliyun.com/repository/public") }
    }
}

tasks.register<Delete>("clean").configure {
    delete(rootProject.buildDir)
}
