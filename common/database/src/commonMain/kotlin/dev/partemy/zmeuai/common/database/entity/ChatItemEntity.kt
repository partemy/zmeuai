package dev.partemy.zmeuai.common.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChatItemEntity(
    @PrimaryKey(autoGenerate = true) val chatItemId: Long = 0,
    val chatId: Long,
    val type: String,
    val message: String,
)