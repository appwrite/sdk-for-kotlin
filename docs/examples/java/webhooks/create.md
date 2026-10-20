```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.Webhooks;
import java.util.List;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Webhooks webhooks = new Webhooks(client);

try {
    webhooks.create(
        "<WEBHOOK_ID>", // webhookId
        "https://example.com/webhook", // url
        "<NAME>", // name
        List.of("users.*.create"), // events
        false, // enabled (optional)
        false, // tls (optional)
        "<AUTH_USERNAME>", // authUsername (optional)
        "password", // authPassword (optional)
        "<SECRET>", // secret (optional)
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
