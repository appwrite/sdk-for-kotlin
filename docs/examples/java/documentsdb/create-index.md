```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.DocumentsDB;
import io.appwrite.enums.DocumentsDBIndexType;
import io.appwrite.enums.OrderBy;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

DocumentsDB documentsDB = new DocumentsDB(client);

documentsDB.createIndex(
    "<DATABASE_ID>", // databaseId
    "<COLLECTION_ID>", // collectionId
    "", // key
    DocumentsDBIndexType.KEY, // type
    List.of(), // attributes
    List.of(OrderBy.ASC), // orders (optional)
    List.of(), // lengths (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
