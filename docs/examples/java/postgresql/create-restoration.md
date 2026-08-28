```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Postgresql;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Postgresql postgresql = new Postgresql(client);

postgresql.createRestoration(
    "<DATABASE_ID>", // databaseId
    "backup", // type (optional)
    "<BACKUP_ID>", // backupId (optional)
    "<TARGET_DATABASE_ID>", // targetDatabaseId (optional)
    "2020-10-15T06:38:00.000+00:00", // targetTime (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
