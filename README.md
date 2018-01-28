[![Donation](https://img.shields.io/badge/donate-please-brightgreen.svg)](https://www.paypal.me/janrabe) [![About Jan Rabe](https://img.shields.io/badge/about-me-green.svg)](https://about.me/janrabe)
# KotlinAndroidExtensions [![](https://jitpack.io/v/kibotu/KotlinAndroidExtensions.svg)](https://jitpack.io/#kibotu/KotlinAndroidExtensions) [![Javadoc](https://img.shields.io/badge/javadoc-SNAPSHOT-green.svg)](https://jitpack.io/com/github/kibotu/KotlinAndroidExtensions/master-SNAPSHOT/javadoc/index.html) [![Build Status](https://travis-ci.org/kibotu/KotlinAndroidExtensions.svg?branch=master)](https://travis-ci.org/kibotu/KotlinAndroidExtensions) [![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)  [![Gradle Version](https://img.shields.io/badge/gradle-4.5-green.svg)](https://docs.gradle.org/current/release-notes) [![Retrolambda](https://img.shields.io/badge/kotlin-1.2.21-green.svg)](https://kotlinlang.org/) [![Licence](https://img.shields.io/badge/licence-Apache%202-blue.svg)](https://raw.githubusercontent.com/kibotu/KotlinAndroidExtensions/master/LICENSE)

## Introduction


## How to install

    repositories {
        maven {
            url "https://jitpack.io"
        }
    }

    dependencies {
        implementation 'com.github.kibotu:KotlinAndroidExtensions:-SNAPSHOT'
    }

## How to use

To avoid passing the context everywhere inside the app, we set a weak reference during app start.

1) Add ContextHelper to Application#onCreate

        @Override
        public void onCreate() {
            super.onCreate();

            ContextHelper.with(this);
        }

        @Override
        public void onTerminate() {
            super.onTerminate();

            ContextHelper.onTerminate();
        }

## How to build

    graldew clean build

### CI

    gradlew clean assembleRelease test javadoc

#### Build Requirements

- JDK8
- Android Build Tools 27.0.3
- Android SDK 27

## Contributors

- [Jan Rabe](jan.rabe@kibotu.net)

### License

<pre>
Copyright 2018 Jan Rabe

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>
