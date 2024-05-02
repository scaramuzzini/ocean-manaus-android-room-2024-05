package com.oceanbrasil.ia.meuprimeiroprojeto

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AlunoEntity::class], version=1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun alunoDao(): AlunoDao
}