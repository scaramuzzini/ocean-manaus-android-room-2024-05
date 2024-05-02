package com.oceanbrasil.ia.meuprimeiroprojeto

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.oceanbrasil.ia.meuprimeiroprojeto.AlunoEntity
import com.oceanbrasil.ia.meuprimeiroprojeto.AppDatabase
import com.oceanbrasil.ia.meuprimeiroprojeto.ui.theme.MeuPrimeiroProjetoTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    private lateinit var alunoEntity: AlunoEntity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setContent {
            MeuPrimeiroProjetoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.padding(), color = MaterialTheme.colorScheme.background) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        val alunoName = viewModel.alunoName.collectAsState().value
                        Text(text = alunoName)
                    }
                }
            }
        }
    }
}

@Composable
fun InputForm() {
    var texto by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Digite algo") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                // Aqui você pode adicionar lógica para lidar com o pressionamento de "Done" no teclado
            }),
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = {
                // Aqui você pode adicionar lógica para lidar com o clique do botão
                // Por exemplo, exibir o texto digitado
                Toast.makeText(context, texto, Toast.LENGTH_SHORT).show()

            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Enviar")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeuPrimeiroProjetoTheme {
        Greeting("Android")
    }
}