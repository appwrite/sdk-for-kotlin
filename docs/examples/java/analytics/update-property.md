```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.Analytics;
import io.appwrite.enums.AnalyticsPropertyType;
import java.util.List;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Analytics analytics = new Analytics(client);

try {
    analytics.updateProperty(
        "<PROPERTY_ID>", // propertyId
        "<NAME>", // name (optional)
        "<DOMAIN>", // domain (optional)
        false, // enabled (optional)
        List.of(), // allowedOrigins (optional)
        false, // identifyUsers (optional)
        AnalyticsPropertyType.WEB, // type (optional)
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
