package pdm.study

import androidx.compose.ui.res.painterResource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pdm.study.ui.theme.StudyTheme

class GrupoEstudos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val grupoEstudos = GrupoEstudosDados(
                        tema = "Aprofundar Conhecimentos em Gráficos",
                        fotoGrupo = R.drawable.foto_turma,
                        estatisticas = GrupoEstudosDados.Estatisticas(
                            objetivosConcluidos = 10,
                            horasEstudadas = 20,
                            materias = listOf("Matemática", "Física")
                        ),
                        membros = mutableListOf("Membro 1", "Membro 2", "Membro 3")
                    )
                    GrupoEstudosScreen(grupoEstudos = grupoEstudos)
                }
            }
        }
    }
}

data class GrupoEstudosDados(
    val tema: String,
    var fotoGrupo: Int,
    var estatisticas: Estatisticas = Estatisticas(),
    var membros: MutableList<String> = mutableListOf()
) {
    data class Estatisticas(
        var objetivosConcluidos: Int = 0,
        var horasEstudadas: Int = 0,
        var materias: List<String> = listOf()
    )
}

@Composable
fun GrupoEstudosScreen(grupoEstudos: GrupoEstudosDados) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = grupoEstudos.fotoGrupo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Tema do grupo: ${grupoEstudos.tema}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Estatísticas:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            IconWithTextDesafio(Icons.Default.Check, "${grupoEstudos.estatisticas.objetivosConcluidos} Objetivos Concluídos")
            Spacer(modifier = Modifier.width(16.dp))
            IconWithTextDesafio(Icons.Default.Check, "${grupoEstudos.estatisticas.horasEstudadas} Horas Estudadas")
        }

        Text(
            text = "Matérias: ${grupoEstudos.estatisticas.materias.joinToString(", ")}",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Membros do grupo:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(grupoEstudos.membros) { membro ->
                Text(
                    text = membro,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun IconWithTextDesafio(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            fontSize = 14.sp
        )
    }
}

@Composable
fun GrupoEstudosPreview() {
    StudyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val grupoEstudos = GrupoEstudosDados(
                tema = "Aprofundar Conhecimentos em Gráficos",
                fotoGrupo = R.drawable.foto_turma,
                estatisticas = GrupoEstudosDados.Estatisticas(
                    objetivosConcluidos = 10,
                    horasEstudadas = 20,
                    materias = listOf("Matemática", "Física")
                ),
                membros = mutableListOf("Membro 1", "Membro 2", "Membro 3")
            )
            GrupoEstudosScreen(grupoEstudos = grupoEstudos)
        }
    }
}

@Preview
@Composable
fun GrupoEstudosPreviewWrapper() {
    GrupoEstudosPreview()
}