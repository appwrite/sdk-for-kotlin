```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Project;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Project project = new Project(client);

project.updateOAuth2Server(
    false, // enabled
    "https://example.com", // authorizationUrl
    List.of(), // scopes (optional)
    List.of(), // authorizationDetailsTypes (optional)
    60, // accessTokenDuration (optional)
    60, // refreshTokenDuration (optional)
    60, // publicAccessTokenDuration (optional)
    60, // publicRefreshTokenDuration (optional)
    60, // installationAccessTokenDuration (optional)
    false, // confidentialPkce (optional)
    "https://example.com", // verificationUrl (optional)
    6, // userCodeLength (optional)
    "numeric", // userCodeFormat (optional)
    60, // deviceCodeDuration (optional)
    List.of(), // defaultScopes (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
