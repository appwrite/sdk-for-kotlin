```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Organization;
import io.appwrite.enums.OrganizationKeyScopes;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Organization organization = new Organization(client);

organization.updateKey(
    "<KEY_ID>", // keyId
    "<NAME>", // name
    List.of(OrganizationKeyScopes.PROJECTS_READ), // scopes
    "2020-10-15T06:38:00.000+00:00", // expire (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
