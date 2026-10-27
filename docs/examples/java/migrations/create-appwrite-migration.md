```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.Migrations;
import io.appwrite.enums.AppwriteMigrationResource;
import io.appwrite.enums.OnDuplicate;
import java.util.List;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Migrations migrations = new Migrations(client);

try {
    migrations.createAppwriteMigration(
        List.of(AppwriteMigrationResource.USER), // resources
        "https://example.com", // endpoint
        "<PROJECT_ID>", // projectId
        "<API_KEY>", // apiKey
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
