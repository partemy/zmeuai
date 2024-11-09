package dev.partemy.zmeuai.common.domain.model

enum class ChatItemType(val role: String) {
    USER(role = "user"),
    TEXT(role = "model"),
    IMAGE(role = "model")
}