import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Messaging;

Client client = new Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("5df5acd0d48c2") // Your project ID
    .setKey("919c2d18fb5d4...a2ae413da83346ad2"); // Your secret API key

Messaging messaging = new Messaging(client);

messaging.updateSendgridProvider(
    "<PROVIDER_ID>", // providerId
    "<NAME>", // name (optional)
    false, // enabled (optional)
    "<API_KEY>", // apiKey (optional)
    "<FROM_NAME>", // fromName (optional)
    "email@example.com", // fromEmail (optional)
    "<REPLY_TO_NAME>", // replyToName (optional)
    "<REPLY_TO_EMAIL>", // replyToEmail (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

