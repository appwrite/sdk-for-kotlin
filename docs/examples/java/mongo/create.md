```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Mongo;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Mongo mongo = new Mongo(client);

mongo.create(
    "<DATABASE_ID>", // databaseId
    "<NAME>", // name
    "17", // version (optional)
    "<SPECIFICATION>", // specification (optional)
    0, // replicas (optional)
    "async", // syncMode (optional)
    60, // networkIdleTimeoutSeconds (optional)
    List.of(), // networkIPAllowlist (optional)
    5, // idleTimeoutMinutes (optional)
    false, // pitr (optional)
    1, // pitrRetentionDays (optional)
    false, // storageAutoscaling (optional)
    50, // storageAutoscalingThresholdPercent (optional)
    0, // storageAutoscalingMaxGb (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
