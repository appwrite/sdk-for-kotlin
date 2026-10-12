```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Storage;
import io.appwrite.enums.ImageGravity;
import io.appwrite.enums.ImageFormat;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession(""); // The user session to authenticate with

Storage storage = new Storage(client);

storage.getFilePreview(
    "<BUCKET_ID>", // bucketId
    "<FILE_ID>", // fileId
    0L, // width (optional)
    0L, // height (optional)
    ImageGravity.AUTO, // gravity (optional)
    -1L, // quality (optional)
    0L, // borderWidth (optional)
    "FFFFFF", // borderColor (optional)
    0L, // borderRadius (optional)
    0.0, // opacity (optional)
    -360L, // rotation (optional)
    "FFFFFF", // background (optional)
    ImageFormat.JPG, // output (optional)
    "<TOKEN>", // token (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
