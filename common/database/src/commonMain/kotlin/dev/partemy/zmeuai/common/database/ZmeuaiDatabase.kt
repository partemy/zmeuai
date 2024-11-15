package dev.partemy.zmeuai.common.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import dev.partemy.zmeuai.common.database.dao.ChatDao
import dev.partemy.zmeuai.common.database.entity.ChatItemEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO


@Database(entities = [ChatItemEntity::class], version = 2)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class ZmeuaiDatabase : RoomDatabase() {
    abstract fun chatDao(): ChatDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<ZmeuaiDatabase> {
    override fun initialize(): ZmeuaiDatabase
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<ZmeuaiDatabase>
): ZmeuaiDatabase {
    return builder
        .fallbackToDestructiveMigration(dropAllTables = true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}