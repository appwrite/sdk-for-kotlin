```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.Permission;
import io.appwrite.Role;
import io.appwrite.services.Presences;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Presences presences = new Presences(client);

presences.update(
    "<PRESENCE_ID>", // presenceId
    "<USER_ID>", // userId
    "<STATUS>", // status (optional)
    "2020-10-15T06:38:00.000+00:00", // expiresAt (optional)
    Map.of("a", "b"), // metadata (optional)
    List.of(Permission.read(Role.any())), // permissions (optional)
    false, // purge (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
