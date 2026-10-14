```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Organization;
import io.appwrite.enums.ProjectKeyScopes;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Organization organization = new Organization(client);

organization.createEphemeralProjectKey(
    "<PROJECT_ID>", // projectId
    List.of(ProjectKeyScopes.USERS_READ), // scopes
    600L, // duration
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
