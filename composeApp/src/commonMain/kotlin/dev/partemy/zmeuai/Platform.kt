package dev.partemy.zmeuai

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform