```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Waf;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Waf waf = new Waf(client);

waf.createRedirectRule(
    "<RULE_ID>", // ruleId
    "api", // resourceType
    "<NAME>", // name
    "<LOCATION>", // location
    300L, // statusCode
    "<RESOURCE_ID>", // resourceId (optional)
    "<DESCRIPTION>", // description (optional)
    -100000L, // priority (optional)
    false, // enabled (optional)
    List.of(), // conditions (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
