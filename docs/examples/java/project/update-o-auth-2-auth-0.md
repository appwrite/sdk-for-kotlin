```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Project;
import io.appwrite.enums.ProjectOAuth2Auth0Prompt;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Project project = new Project(client);

project.updateOAuth2Auth0(
    "<CLIENT_ID>", // clientId (optional)
    "<CLIENT_SECRET>", // clientSecret (optional)
    "<ENDPOINT>", // endpoint (optional)
    List.of(ProjectOAuth2Auth0Prompt.NONE), // prompt (optional)
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
