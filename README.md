# Appwrite Kotlin SDK

![Maven Central](https://img.shields.io/maven-central/v/io.appwrite/sdk-for-kotlin.svg?color=green&style=flat-square)
![License](https://img.shields.io/github/license/appwrite/sdk-for-kotlin.svg?style=flat-square)
![Version](https://img.shields.io/badge/api%20version-0.12.0-blue.svg?style=flat-square)
[![Twitter Account](https://img.shields.io/twitter/follow/appwrite_io?color=00acee&label=twitter&style=flat-square)](https://twitter.com/appwrite_io)
[![Discord](https://img.shields.io/discord/564160730845151244?label=discord&style=flat-square)](https://appwrite.io/discord)

**This SDK is compatible with Appwrite server version 0.12.x. For older versions, please check [previous releases](https://github.com/appwrite/sdk-for-kotlin/releases).**

 > This is the Kotlin SDK for integrating with Appwrite from your Kotlin server-side code. If you're looking for the Android SDK you should check [appwrite/sdk-for-android](https://github.com/appwrite/sdk-for-android)

Appwrite is an open-source backend as a service server that abstract and simplify complex and repetitive development tasks behind a very simple to use REST API. Appwrite aims to help you develop your apps faster and in a more secure way. Use the Kotlin SDK to integrate your app with the Appwrite server to easily start interacting with all of Appwrite backend APIs and tools. For full API documentation and tutorials go to [https://appwrite.io/docs](https://appwrite.io/docs)

![Appwrite](https://appwrite.io/images/github.png)

## Installation

### Gradle

Appwrite's Kotlin SDK is hosted on Maven Central. In order to fetch the Appwrite SDK, add this to your root level `build.gradle(.kts)` file:

```groovy
repositories {      
    mavenCentral()
}
```

If you would like to fetch our SNAPSHOT releases, you need to add the SNAPSHOT maven repository to your `build.gradle(.kts)`:

```groovy
repositories {
    maven {
        url "https://s01.oss.sonatype.org/content/repositories/snapshots/"
    }
}
```

Next, add the dependency to your project's `build.gradle(.kts)` file:

```groovy
implementation("io.appwrite:sdk-for-kotlin:0.1.1")
```

### Maven
Add this to your project's `pom.xml` file:

```xml
<dependencies>
    <dependency>
        <groupId>io.appwrite</groupId>
        <artifactId>sdk-for-kotlin</artifactId>
        <version>0.1.1</version>
    </dependency>
</dependencies>
```


## Getting Started

### Init your SDK

Initialize your SDK with your Appwrite server API endpoint and project ID which can be found in your project settings page and your new API secret Key project API keys section.

```kotlin
import io.appwrite.Client
import io.appwrite.services.Account

suspend fun main() {
    val client = Client(context)
      .setEndpoint("https://[HOSTNAME_OR_IP]/v1") // Your API Endpoint
      .setProject("5df5acd0d48c2") // Your project ID
      .setKey('919c2d18fb5d4...a2ae413da83346ad2') // Your secret API key
      .setSelfSigned(true) // Use only on dev mode with a self-signed SSL cert
}
```

### Make Your First Request

Once your SDK object is set, create any of the Appwrite service objects and choose any request to send. Full documentation for any service method you would like to use can be found in your SDK documentation or in the [API References](https://appwrite.io/docs) section.

```kotlin
val users = Users(client)
val response = users.create(
    email = "email@example.com",
    password = "password",
)
val json = response.body?.string()
```

### Full Example

```kotlin
import io.appwrite.Client
import io.appwrite.services.Users

suspend fun main() {
    val client = Client(context)
      .setEndpoint("https://[HOSTNAME_OR_IP]/v1") // Your API Endpoint
      .setProject("5df5acd0d48c2") // Your project ID
      .setKey('919c2d18fb5d4...a2ae413da83346ad2') // Your secret API key
      .setSelfSigned(true) // Use only on dev mode with a self-signed SSL cert

    val users = Users(client)
    val response = users.create(
        email = "email@example.com",
        password = "password",
    )
    val json = response.body?.string()
}
```

### Error Handling

The Appwrite Kotlin SDK raises `AppwriteException` object with `message`, `code` and `response` properties. You can handle any errors by catching `AppwriteException` and present the `message` to the user or handle it yourself based on the provided error information. Below is an example.

```kotlin
import io.appwrite.Client
import io.appwrite.services.Users

suspend fun main() {
    val users = Users(client)
    try {
        val response = users.create(
            email = "email@example.com",
            password = "password",
        )
        var jsonString = response.body?.string() ?: ""

    } catch (e: AppwriteException) {
        println(e)
    }
}
```

### Learn more

You can use the following resources to learn more and get help

- 🚀 [Getting Started Tutorial](https://appwrite.io/docs/getting-started-for-server)
- 📜 [Appwrite Docs](https://appwrite.io/docs)
- 💬 [Discord Community](https://appwrite.io/discord)
- 🚂 [Appwrite Kotlin Playground](https://github.com/appwrite/playground-for-kotlin)


## Contribution

This library is auto-generated by Appwrite custom [SDK Generator](https://github.com/appwrite/sdk-generator). To learn more about how you can help us improve this SDK, please check the [contribution guide](https://github.com/appwrite/sdk-generator/blob/master/CONTRIBUTING.md) before sending a pull-request.

## License

Please see the [BSD-3-Clause license](https://raw.githubusercontent.com/appwrite/appwrite/master/LICENSE) file for more information.