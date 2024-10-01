import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Functions;
import io.appwrite.enums.Runtime;

Client client = new Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Functions functions = new Functions(client);

functions.create(
    "{$example}", // functionId
    "{$example}", // name
    .NODE_14_5, // runtime
    listOf("any"), // execute (optional)
    listOf(), // events (optional)
    "", // schedule (optional)
    1, // timeout (optional)
    false, // enabled (optional)
    false, // logging (optional)
    "{$example}", // entrypoint (optional)
    "{$example}", // commands (optional)
    listOf(), // scopes (optional)
    "{$example}", // installationId (optional)
    "{$example}", // providerRepositoryId (optional)
    "{$example}", // providerBranch (optional)
    false, // providerSilentMode (optional)
    "{$example}", // providerRootDirectory (optional)
    "{$example}", // templateRepository (optional)
    "{$example}", // templateOwner (optional)
    "{$example}", // templateRootDirectory (optional)
    "{$example}", // templateVersion (optional)
    "", // specification (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

