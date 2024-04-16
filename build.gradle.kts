// Top-level build file where you can add configuration options common to all sub-projects/modules.
//dependencies {
//
//    classpath ("com.google.dagger:hilt-android-gradle-plugin:{latest-version}")
//}

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id ("com.google.dagger.hilt.android") version "2.45" apply false

}