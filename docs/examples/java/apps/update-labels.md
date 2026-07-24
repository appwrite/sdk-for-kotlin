```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Apps;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Apps apps = new Apps(client);

apps.updateLabels(
    "<APP_ID>", // appId
    List.of(), // labels
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
