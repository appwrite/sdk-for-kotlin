```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Proxy;
import io.appwrite.enums.StatusCode;
import io.appwrite.enums.ProxyResourceType;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Proxy proxy = new Proxy(client);

proxy.createRedirectRule(
    "", // domain
    "https://example.com", // url
    StatusCode.MOVEDPERMANENTLY, // statusCode
    "<RESOURCE_ID>", // resourceId
    ProxyResourceType.SITE, // resourceType
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
