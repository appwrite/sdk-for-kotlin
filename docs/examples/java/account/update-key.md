```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Account;
import io.appwrite.enums.Scopes;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession(""); // The user session to authenticate with

Account account = new Account(client);

account.updateKey(
    "<KEY_ID>", // keyId
    "<NAME>", // name
    List.of(Scopes.ACCOUNT), // scopes
    "", // expire (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
