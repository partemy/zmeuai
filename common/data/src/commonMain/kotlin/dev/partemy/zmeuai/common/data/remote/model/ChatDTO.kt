package dev.partemy.zmeuai.common.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class ChatDTO(
    val history: List<History>,
    val new_message: String
)