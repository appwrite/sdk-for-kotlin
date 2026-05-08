```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Project;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Project project = new Project(client);

project.updateOAuth2Oidc(
    "<CLIENT_ID>", // clientId (optional)
    "<CLIENT_SECRET>", // clientSecret (optional)
    "https://example.com", // wellKnownURL (optional)
    "https://example.com", // authorizationURL (optional)
    "https://example.com", // tokenURL (optional)
    "https://example.com", // userInfoURL (optional)
    false, // enabled (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
