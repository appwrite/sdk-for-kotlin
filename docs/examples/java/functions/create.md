```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Functions;
import io.appwrite.enums.Runtime;
import io.appwrite.enums.ProjectKeyScopes;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Functions functions = new Functions(client);

functions.create(
    "<FUNCTION_ID>", // functionId
    "<NAME>", // name
    Runtime.NODE_14_5, // runtime
    List.of("any"), // execute (optional)
    List.of(), // events (optional)
    "0 0 * * *", // schedule (optional)
    1, // timeout (optional)
    false, // enabled (optional)
    false, // logging (optional)
    "<ENTRYPOINT>", // entrypoint (optional)
    "<COMMANDS>", // commands (optional)
    List.of(ProjectKeyScopes.PROJECT_READ), // scopes (optional)
    "<INSTALLATION_ID>", // installationId (optional)
    "<PROVIDER_REPOSITORY_ID>", // providerRepositoryId (optional)
    "<PROVIDER_BRANCH>", // providerBranch (optional)
    false, // providerSilentMode (optional)
    "<PROVIDER_ROOT_DIRECTORY>", // providerRootDirectory (optional)
    List.of(), // providerBranches (optional)
    List.of(), // providerPaths (optional)
    "s-1vcpu-512mb", // buildSpecification (optional)
    "s-1vcpu-512mb", // runtimeSpecification (optional)
    0, // deploymentRetention (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
