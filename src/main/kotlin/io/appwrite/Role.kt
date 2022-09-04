package io.appwrite

class Role {
    companion object {
        fun any(): String
            = "any"
        fun user(id: String): String
            = "user:$id"
        fun users(): String
            = "users"
        fun guests(): String
            = "guests"
        fun team(id: String, role: String = ""): String
            = if(role.isEmpty()) {
                "team:$id"
            } else {
                "team:$id/$role"
            }
        fun status(status: String): String
            = "status:$status"
    }
}