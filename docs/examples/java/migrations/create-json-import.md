```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.Migrations;
import io.appwrite.enums.OnDuplicate;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Migrations migrations = new Migrations(client);

try {
    migrations.createJSONImport(
        "<BUCKET_ID>", // bucketId
        "<FILE_ID>", // fileId
        "<DATABASE_ID>", // databaseId
        "<COLLECTION_ID>", // collectionId
        false, // internalFile (optional)
        OnDuplicate.FAIL, // onDuplicate (optional)
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
