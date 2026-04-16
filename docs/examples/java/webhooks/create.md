```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Webhooks;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Webhooks webhooks = new Webhooks(client);

webhooks.create(
    "<WEBHOOK_ID>", // webhookId
    "", // url
    "<NAME>", // name
    List.of(), // events
    false, // enabled (optional)
    false, // tls (optional)
    "<AUTH_USERNAME>", // authUsername (optional)
    "<AUTH_PASSWORD>", // authPassword (optional)
    "<SECRET>", // secret (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
