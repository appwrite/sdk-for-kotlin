import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Messaging;

Client client = new Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Messaging messaging = new Messaging(client);

messaging.updateMailgunProvider(
    "{$example}", // providerId
    "{$example}", // name (optional)
    "{$example}", // apiKey (optional)
    "{$example}", // domain (optional)
    false, // isEuRegion (optional)
    false, // enabled (optional)
    "{$example}", // fromName (optional)
    "{$example}", // fromEmail (optional)
    "{$example}", // replyToName (optional)
    "{$example}", // replyToEmail (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

