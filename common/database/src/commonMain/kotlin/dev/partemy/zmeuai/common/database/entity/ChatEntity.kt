package dev.partemy.zmeuai.common.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChatEntity(
    @PrimaryKey(autoGenerate = true) val chatId: Long = 0,
    val title: String?,
    val text: String?,
    val creationTime: Long,
)
