

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id("com.android.library") version "7.1.0" apply false
    id ("com.google.dagger.hilt.android") version "2.44" apply false

}

