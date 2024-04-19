

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id("com.android.library") version "7.1.0" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"


}

