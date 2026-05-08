```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Project
import io.appwrite.enums.EmailTemplateType
import io.appwrite.enums.EmailTemplateLocale

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val project = Project(client)

val response = project.getEmailTemplate(
    templateId = EmailTemplateType.VERIFICATION,
    locale = EmailTemplateLocale.AF // optional
)
```
