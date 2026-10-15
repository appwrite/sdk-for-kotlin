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
    0L, // replicas (optional)
    "async", // syncMode (optional)
    60L, // networkIdleTimeoutSeconds (optional)
    List.of(), // networkIPAllowlist (optional)
    5L, // idleTimeoutMinutes (optional)
    false, // pitr (optional)
    1L, // pitrRetentionDays (optional)
    false, // storageAutoscaling (optional)
    50L, // storageAutoscalingThresholdPercent (optional)
    0L, // storageAutoscalingMaxGb (optional)
    0.0, // metricsTraceSampleRate (optional)
    0L, // metricsSlowQueryLogThresholdMs (optional)
    false, // sqlApiEnabled (optional)
    List.of(), // sqlApiAllowedStatements (optional)
    1L, // sqlApiMaxRows (optional)
    1024L, // sqlApiMaxBytes (optional)
    1L, // sqlApiTimeoutSeconds (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
