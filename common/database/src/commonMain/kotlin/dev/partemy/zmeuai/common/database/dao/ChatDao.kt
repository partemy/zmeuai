package dev.partemy.zmeuai.common.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.partemy.zmeuai.common.database.entity.ChatEntity
import dev.partemy.zmeuai.common.database.entity.ChatItemEntity
import dev.partemy.zmeuai.common.database.relations.ChatWithMessages
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {

    @Insert
    suspend fun addChat(chat: ChatEntity)

    @Insert
    suspend fun addChatItem(message: ChatItemEntity)

    @Query("SELECT * FROM ChatEntity WHERE chatId = :chatId")
    fun getChatWithMessages(chatId: Long): Flow<ChatWithMessages>

    @Query("SELECT * FROM ChatEntity")
    fun getAllChats(): Flow<List<ChatEntity>>

    @Query("SELECT * FROM ChatEntity ORDER BY chatId DESC LIMIT 1")
    suspend fun getLastChat(): ChatEntity?

    @Query("UPDATE ChatEntity SET title = :title WHERE chatId = :id")
    suspend fun updateTitle(title: String, id: Long)

    @Query("UPDATE ChatEntity SET text = :text WHERE chatId = :id")
    suspend fun updateChatPreviewText(text: String, id: Long)

}