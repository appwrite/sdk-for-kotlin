```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Oauth2;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setSession("") // The user session to authenticate with
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Oauth2 oauth2 = new Oauth2(client);

oauth2.approve(
    "<GRANT_ID>", // grant_id
    "<AUTHORIZATION_DETAILS>", // authorization_details (optional)
    "<SCOPE>", // scope (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
