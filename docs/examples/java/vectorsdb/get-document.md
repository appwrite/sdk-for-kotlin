```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.VectorsDB;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession(""); // The user session to authenticate with

VectorsDB vectorsDB = new VectorsDB(client);

vectorsDB.getDocument(
    "<DATABASE_ID>", // databaseId
    "<COLLECTION_ID>", // collectionId
    "<DOCUMENT_ID>", // documentId
    List.of(), // queries (optional)
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
