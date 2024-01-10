package pdm.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pdm.study.ui.theme.Branco
import pdm.study.ui.theme.Pessego
import pdm.study.ui.theme.StudyTheme

class ContaCadastrar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContaCriar()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContaCriar() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    // Verifique se todos os campos estão preenchidos e se as senhas coincidem
    val isButtonEnabled = name.isNotBlank() && email.isNotBlank() &&
            password.isNotBlank() && confirmPassword.isNotBlank() &&
            password == confirmPassword

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Criar uma conta",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        )
        Spacer(modifier = Modifier.size(12.dp))
        Text(
            text = "Preencha os campos abaixo",
            style = TextStyle(
                fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.size(12.dp))
        Image(
            painter = painterResource(id = R.drawable.maquina_foto),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .padding(16.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.size(24.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { newName : String -> name = newName },
            label = { Text("Nome") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Pessego,  // Opcional: Defina a cor do contorno quando o campo está focado
                unfocusedBorderColor = Color.Black  // Opcional: Defina a cor do contorno quando o campo não está focado
            )
        )
        OutlinedTextField(
            value = email,
            onValueChange = { newEmail : String -> email = newEmail },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Pessego,  // Opcional: Defina a cor do contorno quando o campo está focado
                unfocusedBorderColor = Color.Black  // Opcional: Defina a cor do contorno quando o campo não está focado
            )
        )
        OutlinedTextField(
            value = password,
            onValueChange = { newPassword : String -> password = newPassword },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Pessego,  // Opcional: Defina a cor do contorno quando o campo está focado
                unfocusedBorderColor = Color.Black  // Opcional: Defina a cor do contorno quando o campo não está focado
            )
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { newConfirmPassword : String -> confirmPassword = newConfirmPassword },
            label = { Text("Confirmar Senha") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Pessego,  // Opcional: Defina a cor do contorno quando o campo está focado
                unfocusedBorderColor = Color.Black  // Opcional: Defina a cor do contorno quando o campo não está focado
            )
        )
        Spacer(modifier = Modifier.size(24.dp))
        Button(
            onClick = {
                // Adicione a lógica de criação de conta aqui
            },
            enabled = isButtonEnabled,
            modifier = Modifier.padding(16.dp),
            colors = ButtonDefaults.buttonColors(Pessego)
        ) {
            Text(
                text = "Criar Conta",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            )
        }
    }
}

@Composable
fun ContaCadastrarPreview() {
    StudyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ContaCriar()
        }
    }
}

@Preview
@Composable
fun ContaCadastrarPreviewWrapper() {
    ContaCadastrarPreview()
}

