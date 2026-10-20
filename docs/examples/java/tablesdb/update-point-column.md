```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.TablesDB;
import java.util.List;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

TablesDB tablesDB = new TablesDB(client);

try {
    tablesDB.updatePointColumn(
        "<DATABASE_ID>", // databaseId
        "<TABLE_ID>", // tableId
        "<KEY>", // key
        false, // required
        List.of(1.0, 2.0), // default (optional)
        "<NEW_KEY>", // newKey (optional)
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
