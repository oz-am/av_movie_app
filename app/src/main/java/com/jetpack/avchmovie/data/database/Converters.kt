package com.jetpack.avchmovie.data.database

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromSource(source: List<String>): String {
        return source.joinToString(separator = "<>")
    }

    @TypeConverter
    fun toSource(source: String): List<String> {
        return source.split("<>")
    }

    @TypeConverter
    fun fromIntSource(source: List<Int>): String {
        return source.joinToString(separator = "<>")
    }

    @TypeConverter
    fun toIntSource(source: String): List<Int> {
        return source.split("<>").filter { l -> l.isNotEmpty() }.map { r -> r.toInt() }.toList()
    }
}
