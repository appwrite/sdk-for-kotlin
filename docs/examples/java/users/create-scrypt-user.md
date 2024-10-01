import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Users;

Client client = new Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Users users = new Users(client);

users.createScryptUser(
    "{$example}", // userId
    "{$example}", // email
    "{$example}", // password
    "{$example}", // passwordSalt
    0, // passwordCpu
    0, // passwordMemory
    0, // passwordParallel
    0, // passwordLength
    "{$example}", // name (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

