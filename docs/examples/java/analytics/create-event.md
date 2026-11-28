```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.Analytics;
import java.util.List;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Analytics analytics = new Analytics(client);

try {
    analytics.createEvent(
        "<PROPERTY_ID>", // propertyId
        "<NAME>", // name
        "https://example.com", // url
        "<DOMAIN>", // domain (optional)
        "<REFERRER>", // referrer (optional)
        0L, // screenWidth (optional)
        "<SESSION_HASH>", // sessionHash (optional)
        0L, // scrollDepth (optional)
        0L, // engagementTime (optional)
        List.of(), // props (optional)
        "<USER_ID>", // userId (optional)
        "<IP>", // ip (optional)
        "<USER_AGENT>", // userAgent (optional)
        false, // interactive (optional)
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
