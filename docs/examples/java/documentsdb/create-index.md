```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.DocumentsDB;
import io.appwrite.enums.DocumentsDBIndexType;
import io.appwrite.enums.OrderBy;
import java.util.List;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

DocumentsDB documentsDB = new DocumentsDB(client);

try {
    documentsDB.createIndex(
        "<DATABASE_ID>", // databaseId
        "<COLLECTION_ID>", // collectionId
        "<KEY>", // key
        DocumentsDBIndexType.KEY, // type
        List.of("username"), // attributes
        List.of(OrderBy.ASC), // orders (optional)
        List.of(), // lengths (optional)
        "<DESCRIPTION>", // description (optional)
        new CoroutineCallback<>((result, error) -> {
            if (error != null) {
                error.printStackTrace();
                return;
            }

            System.out.println(result);
        })
    );
} catch (AppwriteException e) {
    e.printStackTrace();
}
```
