import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Messaging;

Client client = new Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Messaging messaging = new Messaging(client);

messaging.createPush(
    "{$example}", // messageId
    "{$example}", // title
    "{$example}", // body
    listOf(), // topics (optional)
    listOf(), // users (optional)
    listOf(), // targets (optional)
    mapOf( "a" to "b" ), // data (optional)
    "{$example}", // action (optional)
    "{$example}", // image (optional)
    "{$example}", // icon (optional)
    "{$example}", // sound (optional)
    "{$example}", // color (optional)
    "{$example}", // tag (optional)
    "{$example}", // badge (optional)
    false, // draft (optional)
    "", // scheduledAt (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

