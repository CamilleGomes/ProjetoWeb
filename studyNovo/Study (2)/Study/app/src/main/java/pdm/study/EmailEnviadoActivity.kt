package pdm.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pdm.study.ui.theme.StudyTheme

class EmailEnviadoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aplicar o tema do estudo
            StudyTheme {
                // Superfície que ocupa todo o tamanho da tela
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Chama a função que contém o conteúdo da tela
                    EmailEnviadoContent()
                }
            }
        }
    }
}

@Composable
fun EmailEnviadoContent() {
    // Coluna que organiza os elementos verticalmente no centro da tela
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Texto que indica que o email foi enviado
        Text(
            text = "Email Enviado",
            modifier = Modifier.padding(8.dp),
        )
        // Texto informativo sobre o envio do email de redefinição de senha
        Text(
            text = "Um email de redefinição de senha foi enviado para o seu endereço de email.",
            modifier = Modifier.padding(8.dp),
        )
        // Você pode adicionar mais informações ou personalizar conforme necessário
    }
}
