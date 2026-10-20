```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.Project;
import io.appwrite.enums.ProjectOAuth2OktaPrompt;
import java.util.List;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Project project = new Project(client);

try {
    project.updateOAuth2Okta(
        "<CLIENT_ID>", // clientId (optional)
        "<CLIENT_SECRET>", // clientSecret (optional)
        "example.com", // domain (optional)
        "<AUTHORIZATION_SERVER_ID>", // authorizationServerId (optional)
        false, // enabled (optional)
        List.of(ProjectOAuth2OktaPrompt.NONE), // prompt (optional)
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
