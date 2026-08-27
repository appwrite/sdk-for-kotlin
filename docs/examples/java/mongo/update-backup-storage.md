```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Mongo;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Mongo mongo = new Mongo(client);

mongo.updateBackupStorage(
    "<DATABASE_ID>", // databaseId
    "s3", // provider
    "<BUCKET>", // bucket
    "<ACCESS_KEY>", // accessKey
    "<SECRET_KEY>", // secretKey
    "<REGION>", // region (optional)
    "<PREFIX>", // prefix (optional)
    "<ENDPOINT>", // endpoint (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
