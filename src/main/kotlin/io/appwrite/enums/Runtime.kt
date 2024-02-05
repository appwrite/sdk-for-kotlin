package io.appwrite.enums

enum class Runtime(val value: String) {
    NODE180("node-18.0"),
    PHP80("php-8.0"),
    RUBY31("ruby-3.1"),
    PYTHON39("python-3.9");

    override fun toString() = value
}