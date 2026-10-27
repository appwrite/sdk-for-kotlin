```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.Migrations;
import java.util.List;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Migrations migrations = new Migrations(client);

try {
    migrations.createCSVExport(
        "<DATABASE_ID>", // databaseId
        "<COLLECTION_ID>", // collectionId
        "<FILENAME>", // filename
        List.of(), // columns (optional)
        List.of(), // queries (optional)
        "<DELIMITER>", // delimiter (optional)
        "<ENCLOSURE>", // enclosure (optional)
        "<ESCAPE>", // escape (optional)
        false, // header (optional)
        false, // notify (optional)
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
