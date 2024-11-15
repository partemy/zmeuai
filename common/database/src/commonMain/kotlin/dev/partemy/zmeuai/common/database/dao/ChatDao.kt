package dev.partemy.zmeuai.common.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.partemy.zmeuai.common.database.entity.ChatItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {
    @Insert
    suspend fun insert(item: ChatItemEntity)

    @Query("SELECT * FROM ChatItemEntity")
    fun getAllAsFlow(): Flow<List<ChatItemEntity>>
}