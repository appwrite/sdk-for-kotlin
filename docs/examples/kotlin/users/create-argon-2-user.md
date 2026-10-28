```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Users

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val users = Users(client)

val response = users.createArgon2User(
    userId = "<USER_ID>",
    email = "email@example.com",
    password = "\$argon2id\$v=19\$m=65536,t=4,p=1\$NC8xaW1CVXlIZXFSQi9FRg\$0bd4pLo1ytyqvCwl5NSijpm5OIe8J6CjZ1vFemKAg+o",
    name = "<NAME>" // optional
)
```
