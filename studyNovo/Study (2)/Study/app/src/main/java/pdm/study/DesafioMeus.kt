package pdm.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pdm.study.ui.theme.Pessego
import pdm.study.ui.theme.StudyTheme

class DesafioMeus : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DesafioMeu(this)
                }
            }
        }
    }
}

@Composable
fun DesafioMeu(activity: ComponentActivity) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Leitura Mensal",
            style = TextStyle(
                fontSize = 20.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp)
                .padding(horizontal = 14.dp)
                .background(Color.White),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(1.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp)
        ) {
            val text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Objetivo: ")
                }
                append("Ler um número específico de livros ou páginas a cada mês")
            }
            Text(
                text = text,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(7.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.size(1.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp)
        ) {
            val text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Regra: ")
                }
                append("Defina um número mínimo de páginas nos livros a serem lidos, e os participantes compartilhem suas leituras e descultem ao longo do mês")
            }

            Text(
                text = text,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(7.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.size(1.dp))
        Text(
            text = "Desafio de memorização de vocabulário",
            style = TextStyle(
                fontSize = 20.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp)
                .padding(horizontal = 14.dp)
                .background(Color.White),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(1.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp)
        ) {
            val text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Objetivo: ")
                }
                append("Expandir o vocabulário em um novo idioma")
            }
            Text(
                text = text,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(7.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.size(1.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp)
        ) {
            val text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Regra: ")
                }
                append("Escolha uma lista de palavras ou frases para aprender a cada semana e teste seu conhecimento em um quiz semanal")
            }

            Text(
                text = text,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(7.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.size(1.dp))
        Text(
            text = "Desafio de redação criativa",
            style = TextStyle(
                fontSize = 20.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp)
                .padding(horizontal = 14.dp)
                .background(Color.White),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(1.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp)
        ) {
            val text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Objetivo: ")
                }
                append("Melhorar as habilidades de escritas criativa")
            }
            Text(
                text = text,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(7.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.size(1.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp)
        ) {
            val text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Regra: ")
                }
                append("Defina um tema ou prompt de escrita semanal e peça aos participantes que escrevam e compartilhem suas criações.")
            }

            Text(
                text = text,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(7.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.size(1.dp))

        Button(
            onClick = {
                activity.finish()
            },
            modifier = Modifier.padding(16.dp),
            colors = ButtonDefaults.buttonColors(Pessego)
        ) {
            Text(
                text = "Sair",
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
fun DesafioMeusPreview() {
    val activity = DesafioMeus() // Substitua por sua própria Activity
    StudyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DesafioMeu(activity)
        }
    }
}

@Preview
@Composable
fun DesafioMeusPreviewWrapper() {
    DesafioMeusPreview()
}