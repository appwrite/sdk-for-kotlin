```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Waf;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Waf waf = new Waf(client);

waf.updateRateLimitRule(
    "<RULE_ID>", // ruleId
    "api", // resourceType (optional)
    "<RESOURCE_ID>", // resourceId (optional)
    "<NAME>", // name (optional)
    "<DESCRIPTION>", // description (optional)
    1L, // limit (optional)
    1L, // interval (optional)
    "ip", // key (optional)
    1L, // maxBucketSize (optional)
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
