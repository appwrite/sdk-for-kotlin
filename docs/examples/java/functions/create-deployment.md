import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.models.InputFile;
import io.appwrite.services.Functions;

Client client = new Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("5df5acd0d48c2") // Your project ID
    .setKey("919c2d18fb5d4...a2ae413da83346ad2"); // Your secret API key

Functions functions = new Functions(client);

functions.createDeployment(
    "<FUNCTION_ID>", // functionId
    InputFile.fromPath("file.png"), // code
    false, // activate
    "<ENTRYPOINT>", // entrypoint (optional)
    "<COMMANDS>", // commands (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

