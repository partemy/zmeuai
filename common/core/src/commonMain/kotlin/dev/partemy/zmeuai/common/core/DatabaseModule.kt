package dev.partemy.zmeuai.common.core

import dev.partemy.zmeuai.common.database.ZmeuaiDatabase
import dev.partemy.zmeuai.common.database.dao.ChatDao
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule: Module = module {
    single<ChatDao> { ZmeuaiDatabase::chatDao.invoke(get()) }
}
