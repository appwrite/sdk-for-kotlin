```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.Query;
import io.appwrite.services.Monitors;
import io.appwrite.enums.MonitorSeverity;
import java.util.List;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Monitors monitors = new Monitors(client);

try {
    monitors.createUsageMonitor(
        "<MONITOR_ID>", // monitorId
        "<NAME>", // name
        List.of(
            Query.greaterThan("network.outbound", 5000000000)
        ), // rules
        3600L, // window (optional)
        1800L, // cooldown (optional)
        true, // enabled (optional)
        List.of("owner"), // notify (optional)
        MonitorSeverity.INFO, // severity (optional)
        "<ESCALATION_ID>", // escalationId (optional)
        new CoroutineCallback<>((result, error) -> {
            if (error != null) {
                error.printStackTrace();
                return;
            }

            System.out.println(result);
        })
    );
} catch (AppwriteException e) {
    e.printStackTrace();
}
```
