```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.Project;
import io.appwrite.enums.ProjectOAuth2GooglePrompt;
import java.util.List;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Project project = new Project(client);

try {
    project.updateOAuth2Google(
        "<CLIENT_ID>", // clientId (optional)
        "<CLIENT_SECRET>", // clientSecret (optional)
        List.of(ProjectOAuth2GooglePrompt.NONE), // prompt (optional)
        false, // enabled (optional)
        List.of(), // nativeClientIds (optional)
        false, // nativeEnabled (optional)
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
