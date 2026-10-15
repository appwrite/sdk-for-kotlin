```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.TablesDB

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val tablesDB = TablesDB(client)

val response = tablesDB.upsertRows(
    databaseId = "<DATABASE_ID>",
    tableId = "<TABLE_ID>",
    rows = listOf(mapOf(
        "\$id" to "example1",
        "username" to "walter.obrien",
        "email" to "walter.obrien@example.com",
        "fullName" to "Walter O'Brien",
        "age" to 30,
        "isAdmin" to false
    )),
    transactionId = "<TRANSACTION_ID>" // optional
)
```
