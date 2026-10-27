package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class EnvironmentResource(val value: String) {
    @SerializedName("user")
    USER("user"),
    @SerializedName("team")
    TEAM("team"),
    @SerializedName("membership")
    MEMBERSHIP("membership"),
    @SerializedName("auth-methods")
    AUTH_METHODS("auth-methods"),
    @SerializedName("policies")
    POLICIES("policies"),
    @SerializedName("oauth2-provider")
    OAUTH2_PROVIDER("oauth2-provider"),
    @SerializedName("database")
    DATABASE("database"),
    @SerializedName("documentsdb")
    DOCUMENTSDB("documentsdb"),
    @SerializedName("vectorsdb")
    VECTORSDB("vectorsdb"),
    @SerializedName("table")
    TABLE("table"),
    @SerializedName("collection")
    COLLECTION("collection"),
    @SerializedName("column")
    COLUMN("column"),
    @SerializedName("attribute")
    ATTRIBUTE("attribute"),
    @SerializedName("index")
    INDEX("index"),
    @SerializedName("row")
    ROW("row"),
    @SerializedName("document")
    DOCUMENT("document"),
    @SerializedName("bucket")
    BUCKET("bucket"),
    @SerializedName("file")
    FILE("file"),
    @SerializedName("function")
    FUNCTION("function"),
    @SerializedName("environment-variable")
    ENVIRONMENT_VARIABLE("environment-variable"),
    @SerializedName("deployment")
    DEPLOYMENT("deployment"),
    @SerializedName("site")
    SITE("site"),
    @SerializedName("site-variable")
    SITE_VARIABLE("site-variable"),
    @SerializedName("site-deployment")
    SITE_DEPLOYMENT("site-deployment"),
    @SerializedName("provider")
    PROVIDER("provider"),
    @SerializedName("topic")
    TOPIC("topic"),
    @SerializedName("subscriber")
    SUBSCRIBER("subscriber"),
    @SerializedName("platform")
    PLATFORM("platform"),
    @SerializedName("smtp")
    SMTP("smtp"),
    @SerializedName("project-variable")
    PROJECT_VARIABLE("project-variable"),
    @SerializedName("project-protocols")
    PROJECT_PROTOCOLS("project-protocols"),
    @SerializedName("project-labels")
    PROJECT_LABELS("project-labels"),
    @SerializedName("project-services")
    PROJECT_SERVICES("project-services"),
    @SerializedName("project-email-template")
    PROJECT_EMAIL_TEMPLATE("project-email-template");

    override fun toString() = value
}
