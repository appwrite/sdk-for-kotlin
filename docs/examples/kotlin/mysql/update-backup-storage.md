```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Mysql

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val mysql = Mysql(client)

val response = mysql.updateBackupStorage(
    databaseId = "<DATABASE_ID>",
    provider = "s3",
    bucket = "<BUCKET>",
    accessKey = "<ACCESS_KEY>",
    secretKey = "<SECRET_KEY>",
    region = "<REGION>", // optional
    prefix = "<PREFIX>", // optional
    endpoint = "<ENDPOINT>" // optional
)
```
