package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class PasswordHash(val value: String) {
    @SerializedName("sha1")
    SHA1("sha1"),
    @SerializedName("sha224")
    SHA224("sha224"),
    @SerializedName("sha256")
    SHA256("sha256"),
    @SerializedName("sha384")
    SHA384("sha384"),
    @SerializedName("sha512/224")
    SHA512224("sha512/224"),
    @SerializedName("sha512/256")
    SHA512256("sha512/256"),
    @SerializedName("sha512")
    SHA512("sha512"),
    @SerializedName("sha3-224")
    SHA3224("sha3-224"),
    @SerializedName("sha3-256")
    SHA3256("sha3-256"),
    @SerializedName("sha3-384")
    SHA3384("sha3-384"),
    @SerializedName("sha3-512")
    SHA3512("sha3-512");

    override fun toString() = value
}