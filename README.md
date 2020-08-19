# BaseMVP

![version](https://img.shields.io/badge/version-1.3.1-blue)

## To use the lib

Add the repository to the gradle project:
```
allprojects {
    repositories {
        maven { url  "https://dl.bintray.com/theolm/BaseMVP" }
    }
}
```

Add the lib to the app gradle:
```
implementation 'com.theolm:basemvp:1.3.1'
```

## To publish a new version

Add this values to the local.properties:
```
bintray.user=theolm
bintray.apikey=???
```

Execute this commands to build and publish the new version:
```
./gradlew install
./gradlew bintrayUpload
```
