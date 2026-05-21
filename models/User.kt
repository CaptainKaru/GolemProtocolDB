import org.json.JSONObject

data class User(
    val id: String,
    var username: String,
    var email: String,
    var role: String,
    var isActive: Boolean = true,
    var createdAt: String
) {
    fun toMap() = mapOf(
        "id" to id,
        "username" to username,
        "email" to email,
        "role" to role,
        "is_active" to isActive,
        "created_at" to createdAt
    )

    fun toJson() = JSONObject(toMap()).toString()

    companion object {
        fun fromMap(map: Map<String, Any?>) = User(
            id = map["id"]?.toString().orEmpty(),
            username = map["username"]?.toString().orEmpty(),
            email = map["email"]?.toString().orEmpty(),
            role = map["role"]?.toString().orEmpty(),
            isActive = map["is_active"].toString().toBoolean(),
            createdAt = map["created_at"]?.toString().orEmpty()
        )

        fun fromJson(source: String) =
            fromMap(JSONObject(source).toMap() as Map<String, Any?>)
    }
}
