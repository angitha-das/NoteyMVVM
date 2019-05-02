package com.example.noteymvp.util

import androidx.room.TypeConverter
import java.util.*

internal object DateConverter {

    //Take timestamp and return date
    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return if (timestamp == null) null else Date(timestamp)
    }

    //Take data and return timestamp
    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return (date?.time)
    }
}