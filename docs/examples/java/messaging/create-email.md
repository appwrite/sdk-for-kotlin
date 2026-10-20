```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.Messaging;
import java.util.List;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Messaging messaging = new Messaging(client);

try {
    messaging.createEmail(
        "<MESSAGE_ID>", // messageId
        "<SUBJECT>", // subject
        "<CONTENT>", // content
        List.of(), // topics (optional)
        List.of(), // users (optional)
        List.of(), // targets (optional)
        List.of(), // cc (optional)
        List.of(), // bcc (optional)
        List.of(), // attachments (optional)
        false, // draft (optional)
        false, // html (optional)
        "2020-10-15T06:38:00.000+00:00", // scheduledAt (optional)
        "email@example.com", // replyToEmail (optional)
        "<REPLY_TO_NAME>", // replyToName (optional)
        List.of(), // emails (optional)
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
