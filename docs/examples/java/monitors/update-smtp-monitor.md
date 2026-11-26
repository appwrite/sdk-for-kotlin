```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.Query;
import io.appwrite.services.Monitors;
import io.appwrite.enums.MonitorTlsMode;
import io.appwrite.enums.MonitorSeverity;
import java.util.List;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Monitors monitors = new Monitors(client);

try {
    monitors.updateSmtpMonitor(
        "<MONITOR_ID>", // monitorId
        "<NAME>", // name (optional)
        "smtp.example.com", // host (optional)
        587L, // port (optional)
        MonitorTlsMode.NONE, // tlsMode (optional)
        List.of(
            Query.or(List.of(
                Query.lessThan("certificateDays", 14),
                Query.greaterThan("latency", 2000)
            ))
        ), // rules (optional)
        60L, // interval (optional)
        10L, // timeout (optional)
        300L, // cooldown (optional)
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
