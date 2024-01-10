package pdm.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pdm.study.ui.theme.Pessego
import pdm.study.ui.theme.StudyTheme

class RedefinirSenhaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RedefinirSenhaContent(this)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RedefinirSenhaContent(activity: ComponentActivity) {
    var email by remember { mutableStateOf("") }
    var emailEnviadoScreenVisible by remember { mutableStateOf(false) }

    if (emailEnviadoScreenVisible) {
        EmailEnviadoConfirmationContent()
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Redefinir Senha",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = "Informe seu email para redefinir a senha",
                style = TextStyle(
                    fontSize = 16.sp
                )
            )
            Spacer(modifier = Modifier.size(12.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { newEmail: String -> email = newEmail },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.White),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Pessego,
                    unfocusedBorderColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.size(24.dp))
            Button(
                onClick = {
                    if (email.isNotBlank()) {
                        emailEnviadoScreenVisible = true
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.9f), // Ajuste o valor para alterar a largura do botão
                colors = ButtonDefaults.buttonColors(Pessego)
            ) {
                Text(
                    "Enviar Email de Redefinição",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                )
            }
        }
    }
}

@Composable
fun EmailEnviadoConfirmationContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Email Enviado",
            modifier = Modifier.padding(8.dp),
        )
        Text(
            text = "Um email de redefinição de senha foi enviado para o seu endereço de email.",
            modifier = Modifier.padding(8.dp),
        )
    }
}
