package dev.partemy.zmeuai.common.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChatItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val chatID: Long,
    val messageID: Long,
    val type: String,
    val message: String,
)