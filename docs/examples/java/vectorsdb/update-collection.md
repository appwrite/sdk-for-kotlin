```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.Permission;
import io.appwrite.Role;
import io.appwrite.services.VectorsDB;
import java.util.List;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

VectorsDB vectorsDB = new VectorsDB(client);

try {
    vectorsDB.updateCollection(
        "<DATABASE_ID>", // databaseId
        "<COLLECTION_ID>", // collectionId
        "<NAME>", // name
        4L, // dimension (optional)
        List.of(Permission.read(Role.any())), // permissions (optional)
        false, // documentSecurity (optional)
        false, // enabled (optional)
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
