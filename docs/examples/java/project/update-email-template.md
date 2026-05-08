```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Project;
import io.appwrite.enums.EmailTemplateType;
import io.appwrite.enums.EmailTemplateLocale;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Project project = new Project(client);

project.updateEmailTemplate(
    EmailTemplateType.VERIFICATION, // templateId
    EmailTemplateLocale.AF, // locale (optional)
    "<SUBJECT>", // subject (optional)
    "<MESSAGE>", // message (optional)
    "<SENDER_NAME>", // senderName (optional)
    "email@example.com", // senderEmail (optional)
    "email@example.com", // replyToEmail (optional)
    "<REPLY_TO_NAME>", // replyToName (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        System.out.println(result);
    })
);

```
