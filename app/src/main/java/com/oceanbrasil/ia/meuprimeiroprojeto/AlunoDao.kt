package com.oceanbrasil.ia.meuprimeiroprojeto

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlunoDao {
    @Query("SELECT * FROM alunos WHERE id = :alunoId")
    fun getAlunoById(alunoId: Long): AlunoEntity
    @Insert
    fun insertAluno(alunoEntity: AlunoEntity)
}