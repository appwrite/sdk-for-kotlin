```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.Project;
import io.appwrite.enums.ProjectLDAPEncryption;
import java.util.List;

Client client = new Client()
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID
    .setKey("<YOUR_API_KEY>"); // Your secret API key

Project project = new Project(client);

try {
    project.updateLDAP(
        false, // enabled (optional)
        List.of("ldap.example.com"), // hosts (optional)
        636L, // port (optional)
        ProjectLDAPEncryption.NONE, // encryption (optional)
        false, // verification (optional)
        "<CERTIFICATE>", // certificate (optional)
        10L, // timeout (optional)
        "ou=people,dc=example,dc=com", // baseDn (optional)
        "cn=appwrite,ou=services,dc=example,dc=com", // bindDn (optional)
        "password", // bindPassword (optional)
        "(uid={username})", // userFilter (optional)
        "cn=staff,ou=groups,dc=example,dc=com", // requiredGroupDn (optional)
        "entryUUID", // idAttribute (optional)
        "mail", // emailAttribute (optional)
        "cn", // nameAttribute (optional)
        "mobile", // phoneAttribute (optional)
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
