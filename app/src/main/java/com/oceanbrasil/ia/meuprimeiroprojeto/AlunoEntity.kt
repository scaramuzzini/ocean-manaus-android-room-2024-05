package com.oceanbrasil.ia.meuprimeiroprojeto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alunos")
data class AlunoEntity(
    @PrimaryKey
    val id: Long,
    val nomeCompleto: String,
)
