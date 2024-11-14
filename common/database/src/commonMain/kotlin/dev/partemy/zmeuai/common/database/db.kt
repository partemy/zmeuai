package dev.partemy.zmeuai.common.database

import androidx.room.ConstructedBy
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow

// shared/src/commonMain/kotlin/Database.kt

@Database(entities = [ZmeuaiEntity::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class ZmeuaiDatabase : RoomDatabase() {
    abstract fun getDao(): ZmeuaiDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<ZmeuaiDatabase> {
    override fun initialize(): ZmeuaiDatabase
}

@Dao
interface ZmeuaiDao {
    @Insert
    suspend fun insert(item: ZmeuaiEntity)

    @Query("SELECT count(*) FROM ZmeuaiEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM ZmeuaiEntity")
    fun getAllAsFlow(): Flow<List<ZmeuaiEntity>>
}

@Entity
data class ZmeuaiEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val content: String
)

fun getRoomDatabase(
    builder: RoomDatabase.Builder<ZmeuaiDatabase>
): ZmeuaiDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}