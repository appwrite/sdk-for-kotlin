```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Project
import io.appwrite.enums.EnvironmentResource

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val project = Project(client)

val response = project.createEnvironment(
    environmentId = "<ENVIRONMENT_ID>",
    name = "<NAME>",
    resources = listOf(EnvironmentResource.DATABASE, EnvironmentResource.TABLE, EnvironmentResource.COLUMN, EnvironmentResource.INDEX, EnvironmentResource.BUCKET, EnvironmentResource.TEAM, EnvironmentResource.FUNCTION, EnvironmentResource.ENVIRONMENT_VARIABLE) // optional
)
```
