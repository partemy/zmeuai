package dev.partemy.zmeuai.common.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class History(
    val parts: String,
    val role: String
)