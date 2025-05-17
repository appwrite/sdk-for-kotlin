package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class Framework(val value: String) {
    @SerializedName("analog")
    ANALOG("analog"),
    @SerializedName("angular")
    ANGULAR("angular"),
    @SerializedName("nextjs")
    NEXTJS("nextjs"),
    @SerializedName("react")
    REACT("react"),
    @SerializedName("nuxt")
    NUXT("nuxt"),
    @SerializedName("vue")
    VUE("vue"),
    @SerializedName("sveltekit")
    SVELTEKIT("sveltekit"),
    @SerializedName("astro")
    ASTRO("astro"),
    @SerializedName("remix")
    REMIX("remix"),
    @SerializedName("lynx")
    LYNX("lynx"),
    @SerializedName("flutter")
    FLUTTER("flutter"),
    @SerializedName("react-native")
    REACT_NATIVE("react-native"),
    @SerializedName("vite")
    VITE("vite"),
    @SerializedName("other")
    OTHER("other");

    override fun toString() = value
}