import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Storage;

Client client = new Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("5df5acd0d48c2") // Your project ID
    .setSession(""); // The user session to authenticate with

Storage storage = new Storage(client);

storage.listFiles(
    "<BUCKET_ID>", // bucketId
    listOf(), // queries (optional)
    "<SEARCH>", // search (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

