```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Analytics
import io.appwrite.enums.AnalyticsInterval
import io.appwrite.enums.AnalyticsDimension

val client = Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>") // Your secret API key

val analytics = Analytics(client)

val response = analytics.listMetrics(
    propertyId = "<PROPERTY_ID>",
    queries = listOf(), // optional
    interval = AnalyticsInterval.ONE_HOUR, // optional
    dimensions = listOf(AnalyticsDimension.COUNTRY), // optional
    propKey = "<PROP_KEY>", // optional
    dateRange = "<DATE_RANGE>", // optional
    startAt = "2020-10-15T06:38:00.000+00:00", // optional
    endAt = "2020-10-15T06:38:00.000+00:00", // optional
    limit = 1, // optional
    total = false // optional
)
```
