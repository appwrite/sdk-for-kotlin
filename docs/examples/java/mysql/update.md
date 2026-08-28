```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Mysql;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Mysql mysql = new Mysql(client);

mysql.update(
    "<DATABASE_ID>", // databaseId
    "<NAME>", // name (optional)
    "ready", // status (optional)
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
    0, // metricsTraceSampleRate (optional)
    0, // metricsSlowQueryLogThresholdMs (optional)
    false, // sqlApiEnabled (optional)
    List.of(), // sqlApiAllowedStatements (optional)
    1, // sqlApiMaxRows (optional)
    1024, // sqlApiMaxBytes (optional)
    1, // sqlApiTimeoutSeconds (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
