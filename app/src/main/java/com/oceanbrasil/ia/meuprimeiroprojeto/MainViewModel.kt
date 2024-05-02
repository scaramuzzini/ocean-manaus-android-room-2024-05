package com.oceanbrasil.ia.meuprimeiroprojeto

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "primeiro-db"
    ).build()

    private val _alunoName = MutableStateFlow("")
    val alunoName = _alunoName.asStateFlow()

    init {
        loadAlunoName()
    }

    private fun loadAlunoName() {
        viewModelScope.launch(Dispatchers.IO) {
            db.alunoDao().insertAluno(AlunoEntity(1, "Joao OCEAN"))
            val aluno = db.alunoDao().getAlunoById(1)
            _alunoName.value = aluno?.nomeCompleto ?: "Not Found"
        }
    }
}
