```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Postgresql;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Postgresql postgresql = new Postgresql(client);

postgresql.updatePooler(
    "<DATABASE_ID>", // databaseId
    "transaction", // mode (optional)
    10, // maxConnections (optional)
    1, // defaultPoolSize (optional)
    false, // readWriteSplitting (optional)
    "<POOLER_CPU_REQUEST>", // poolerCpuRequest (optional)
    "<POOLER_CPU_LIMIT>", // poolerCpuLimit (optional)
    "<POOLER_MEMORY_REQUEST>", // poolerMemoryRequest (optional)
    "<POOLER_MEMORY_LIMIT>", // poolerMemoryLimit (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
