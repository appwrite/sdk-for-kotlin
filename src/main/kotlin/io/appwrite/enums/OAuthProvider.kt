package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class OAuthProvider(val value: String) {
    @SerializedName("amazon")
    AMAZON("amazon"),
    @SerializedName("apple")
    APPLE("apple"),
    @SerializedName("auth0")
    AUTH0("auth0"),
    @SerializedName("authentik")
    AUTHENTIK("authentik"),
    @SerializedName("autodesk")
    AUTODESK("autodesk"),
    @SerializedName("bitbucket")
    BITBUCKET("bitbucket"),
    @SerializedName("bitly")
    BITLY("bitly"),
    @SerializedName("box")
    BOX("box"),
    @SerializedName("dailymotion")
    DAILYMOTION("dailymotion"),
    @SerializedName("discord")
    DISCORD("discord"),
    @SerializedName("disqus")
    DISQUS("disqus"),
    @SerializedName("dropbox")
    DROPBOX("dropbox"),
    @SerializedName("etsy")
    ETSY("etsy"),
    @SerializedName("facebook")
    FACEBOOK("facebook"),
    @SerializedName("figma")
    FIGMA("figma"),
    @SerializedName("github")
    GITHUB("github"),
    @SerializedName("gitlab")
    GITLAB("gitlab"),
    @SerializedName("google")
    GOOGLE("google"),
    @SerializedName("linkedin")
    LINKEDIN("linkedin"),
    @SerializedName("microsoft")
    MICROSOFT("microsoft"),
    @SerializedName("notion")
    NOTION("notion"),
    @SerializedName("oidc")
    OIDC("oidc"),
    @SerializedName("okta")
    OKTA("okta"),
    @SerializedName("paypal")
    PAYPAL("paypal"),
    @SerializedName("paypalSandbox")
    PAYPALSANDBOX("paypalSandbox"),
    @SerializedName("podio")
    PODIO("podio"),
    @SerializedName("salesforce")
    SALESFORCE("salesforce"),
    @SerializedName("slack")
    SLACK("slack"),
    @SerializedName("spotify")
    SPOTIFY("spotify"),
    @SerializedName("stripe")
    STRIPE("stripe"),
    @SerializedName("tradeshift")
    TRADESHIFT("tradeshift"),
    @SerializedName("tradeshiftBox")
    TRADESHIFTBOX("tradeshiftBox"),
    @SerializedName("twitch")
    TWITCH("twitch"),
    @SerializedName("wordpress")
    WORDPRESS("wordpress"),
    @SerializedName("yahoo")
    YAHOO("yahoo"),
    @SerializedName("yammer")
    YAMMER("yammer"),
    @SerializedName("yandex")
    YANDEX("yandex"),
    @SerializedName("zoho")
    ZOHO("zoho"),
    @SerializedName("zoom")
    ZOOM("zoom"),
    @SerializedName("mock")
    MOCK("mock");

    override fun toString() = value
}