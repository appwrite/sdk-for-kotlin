import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Teams

val client = Client()
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("5df5acd0d48c2") // Your project ID
    .setSession("") // The user session to authenticate with

val teams = Teams(client)

val response = teams.listMemberships(
    teamId = "<TEAM_ID>",
    queries = listOf(), // optional
    search = "<SEARCH>" // optional
)
