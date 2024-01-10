package pdm.study

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pdm.study.ui.theme.Pessego
import pdm.study.ui.theme.StudyTheme

class SelecaoGrupoEstudos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GruposDeEstudos(this)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GruposDeEstudos(activity: ComponentActivity) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Lista de temas dos grupos
        val temasGrupos = listOf(
            "Grupo de estudos sobre Gráficos",
            "Grupo de Estudos sobre Android",
            "Grupo de Estudos de Design UI/UX",
            "Grupo de Estudos sobre Machine Learning",
            "Grupo de Estudos de Desenvolvimento Web"
        )

        Text(
            text = "Selecione um Grupo de Estudos",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        )
        Spacer(modifier = Modifier.size(24.dp))

        // Botões para cada grupo de estudos
        for ((index, tema) in temasGrupos.withIndex()) {
            Button(
                onClick = {
                    when (index) {
                        0 -> {
                            // Se o botão "Aprofundar conhecimentos em gráficos" for clicado
                            // Inicia a atividade GrupoEstudos
                            activity.startActivity(
                                Intent(activity, GrupoEstudos::class.java).setFlags(
                                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                                )
                            )
                        }
                        1 -> {
                            // Se o botão "Grupo de Estudos sobre Android" for clicado
                            // Inicia a atividade GrupoEstudos2
                            activity.startActivity(
                                Intent(activity, GrupoEstudos2::class.java).setFlags(
                                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                                )
                            )
                        }
                        2 -> {
                            // Se o botão "Grupo de Estudos de Design UI/UX" for clicado
                            // Inicia a atividade GrupoEstudos3
                            activity.startActivity(
                                Intent(activity, GrupoEstudos3::class.java).setFlags(
                                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                                )
                            )
                        }
                        3 -> {
                            // Se o botão "Grupo de Estudos sobre Machine Learning" for clicado
                            // Inicia a atividade GrupoEstudos4
                            activity.startActivity(
                                Intent(activity, GrupoEstudos4::class.java).setFlags(
                                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                                )
                            )
                        }
                        4 -> {
                            // Se o botão "Grupo de Estudos sobre Desenvolvimento Web" for clicado
                            // Inicia a atividade GrupoEstudos5
                            activity.startActivity(
                                Intent(activity, GrupoEstudos5::class.java).setFlags(
                                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                                )
                            )
                        }
                        else -> {
                            Toast.makeText(
                                activity,
                                "Você selecionou o grupo: $tema",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.7f), // Manter o mesmo valor para todos os botões
                colors = ButtonDefaults.buttonColors(Pessego)
            ) {
                Text(
                    tema,
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
fun GruposDeEstudosPreview() {
    StudyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GruposDeEstudos(activity = ComponentActivity())
        }
    }
}

@Preview
@Composable
fun GruposDeEstudosPreviewWrapper() {
    GruposDeEstudosPreview()
}
