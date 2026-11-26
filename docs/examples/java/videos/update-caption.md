```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.Videos;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setSession(""); // The user session to authenticate with

Videos videos = new Videos(client);

try {
    videos.updateCaption(
        "<VIDEO_ID>", // videoId
        "<CAPTION_ID>", // captionId
        "<BUCKET_ID>", // bucketId (optional)
        "<FILE_ID>", // fileId (optional)
        "<NAME>", // name (optional)
        "aar", // language (optional)
        false, // default (optional)
        new CoroutineCallback<>((result, error) -> {
            if (error != null) {
                error.printStackTrace();
                return;
            }

            System.out.println(result);
        })
    );
} catch (AppwriteException e) {
    e.printStackTrace();
}
```
