package dev.partemy.zmeuai.common.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<ZmeuaiDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("zmeuai.db")
    return Room.databaseBuilder<ZmeuaiDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}