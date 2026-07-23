```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Oauth2;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setSession("") // The user session to authenticate with
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

Oauth2 oauth2 = new Oauth2(client);

oauth2.authorize(
    "<CLIENT_ID>", // client_id (optional)
    "https://example.com", // redirect_uri (optional)
    "", // response_type (optional)
    "<SCOPE>", // scope (optional)
    "<STATE>", // state (optional)
    "<NONCE>", // nonce (optional)
    "<CODE_CHALLENGE>", // code_challenge (optional)
    "s256", // code_challenge_method (optional)
    "<PROMPT>", // prompt (optional)
    0, // max_age (optional)
    "<AUTHORIZATION_DETAILS>", // authorization_details (optional)
    "", // resource (optional)
    "<AUDIENCE>", // audience (optional)
    "<REQUEST_URI>", // request_uri (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
