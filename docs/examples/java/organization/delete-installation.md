```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Organization;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession(""); // The user session to authenticate with

Organization organization = new Organization(client);

organization.deleteInstallation(
    "<INSTALLATION_ID>", // installationId
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
