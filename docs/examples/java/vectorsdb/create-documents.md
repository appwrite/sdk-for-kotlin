```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.VectorsDB;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

VectorsDB vectorsDB = new VectorsDB(client);

vectorsDB.createDocuments(
    "<DATABASE_ID>", // databaseId
    "<COLLECTION_ID>", // collectionId
    List.of(Map.of(
        "$id", "example1",
        "embeddings", List.of(0.12, -0.55, 0.88, 1.02),
        "metadata", Map.of(
            "name", "First document"
        )
    )), // documents
    "<TRANSACTION_ID>", // transactionId (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
