package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class Runtime(val value: String) {
    @SerializedName("node-14.5")
    NODE_14_5("node-14.5"),
    @SerializedName("node-16.0")
    NODE_16_0("node-16.0"),
    @SerializedName("node-18.0")
    NODE_18_0("node-18.0"),
    @SerializedName("node-19.0")
    NODE_19_0("node-19.0"),
    @SerializedName("node-20.0")
    NODE_20_0("node-20.0"),
    @SerializedName("node-21.0")
    NODE_21_0("node-21.0"),
    @SerializedName("node-22")
    NODE_22("node-22"),
    @SerializedName("php-8.0")
    PHP_8_0("php-8.0"),
    @SerializedName("php-8.1")
    PHP_8_1("php-8.1"),
    @SerializedName("php-8.2")
    PHP_8_2("php-8.2"),
    @SerializedName("php-8.3")
    PHP_8_3("php-8.3"),
    @SerializedName("ruby-3.0")
    RUBY_3_0("ruby-3.0"),
    @SerializedName("ruby-3.1")
    RUBY_3_1("ruby-3.1"),
    @SerializedName("ruby-3.2")
    RUBY_3_2("ruby-3.2"),
    @SerializedName("ruby-3.3")
    RUBY_3_3("ruby-3.3"),
    @SerializedName("python-3.8")
    PYTHON_3_8("python-3.8"),
    @SerializedName("python-3.9")
    PYTHON_3_9("python-3.9"),
    @SerializedName("python-3.10")
    PYTHON_3_10("python-3.10"),
    @SerializedName("python-3.11")
    PYTHON_3_11("python-3.11"),
    @SerializedName("python-3.12")
    PYTHON_3_12("python-3.12"),
    @SerializedName("python-ml-3.11")
    PYTHON_ML_3_11("python-ml-3.11"),
    @SerializedName("deno-1.21")
    DENO_1_21("deno-1.21"),
    @SerializedName("deno-1.24")
    DENO_1_24("deno-1.24"),
    @SerializedName("deno-1.35")
    DENO_1_35("deno-1.35"),
    @SerializedName("deno-1.40")
    DENO_1_40("deno-1.40"),
    @SerializedName("deno-1.46")
    DENO_1_46("deno-1.46"),
    @SerializedName("deno-2.0")
    DENO_2_0("deno-2.0"),
    @SerializedName("dart-2.15")
    DART_2_15("dart-2.15"),
    @SerializedName("dart-2.16")
    DART_2_16("dart-2.16"),
    @SerializedName("dart-2.17")
    DART_2_17("dart-2.17"),
    @SerializedName("dart-2.18")
    DART_2_18("dart-2.18"),
    @SerializedName("dart-3.0")
    DART_3_0("dart-3.0"),
    @SerializedName("dart-3.1")
    DART_3_1("dart-3.1"),
    @SerializedName("dart-3.3")
    DART_3_3("dart-3.3"),
    @SerializedName("dart-3.5")
    DART_3_5("dart-3.5"),
    @SerializedName("dotnet-6.0")
    DOTNET_6_0("dotnet-6.0"),
    @SerializedName("dotnet-7.0")
    DOTNET_7_0("dotnet-7.0"),
    @SerializedName("dotnet-8.0")
    DOTNET_8_0("dotnet-8.0"),
    @SerializedName("java-8.0")
    JAVA_8_0("java-8.0"),
    @SerializedName("java-11.0")
    JAVA_11_0("java-11.0"),
    @SerializedName("java-17.0")
    JAVA_17_0("java-17.0"),
    @SerializedName("java-18.0")
    JAVA_18_0("java-18.0"),
    @SerializedName("java-21.0")
    JAVA_21_0("java-21.0"),
    @SerializedName("java-22")
    JAVA_22("java-22"),
    @SerializedName("swift-5.5")
    SWIFT_5_5("swift-5.5"),
    @SerializedName("swift-5.8")
    SWIFT_5_8("swift-5.8"),
    @SerializedName("swift-5.9")
    SWIFT_5_9("swift-5.9"),
    @SerializedName("swift-5.10")
    SWIFT_5_10("swift-5.10"),
    @SerializedName("kotlin-1.6")
    KOTLIN_1_6("kotlin-1.6"),
    @SerializedName("kotlin-1.8")
    KOTLIN_1_8("kotlin-1.8"),
    @SerializedName("kotlin-1.9")
    KOTLIN_1_9("kotlin-1.9"),
    @SerializedName("kotlin-2.0")
    KOTLIN_2_0("kotlin-2.0"),
    @SerializedName("cpp-17")
    CPP_17("cpp-17"),
    @SerializedName("cpp-20")
    CPP_20("cpp-20"),
    @SerializedName("bun-1.0")
    BUN_1_0("bun-1.0"),
    @SerializedName("bun-1.1")
    BUN_1_1("bun-1.1"),
    @SerializedName("go-1.23")
    GO_1_23("go-1.23"),
    @SerializedName("static-1")
    STATIC_1("static-1"),
    @SerializedName("flutter-3.24")
    FLUTTER_3_24("flutter-3.24");

    override fun toString() = value
}