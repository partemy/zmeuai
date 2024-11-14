package dev.partemy.zmeuai.common.core

import androidx.room.RoomDatabase
import dev.partemy.zmeuai.common.database.ZmeuaiDatabase
import dev.partemy.zmeuai.common.database.getDatabaseBuilder
import dev.partemy.zmeuai.common.database.getRoomDatabase
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<RoomDatabase.Builder<ZmeuaiDatabase>> { getDatabaseBuilder(get()) }
    single<ZmeuaiDatabase> { getRoomDatabase(get()) }
}