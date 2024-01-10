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
import pdm.study.R.drawable.technology
import pdm.study.ui.theme.StudyTheme

class GrupoEstudos2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val grupoEstudos2 = GrupoEstudosDados2(
                        tema = "Conhecimentos sobre Android",
                        fotoGrupo = technology,
                        estatisticas = GrupoEstudosDados2.Estatisticas2(
                            objetivosConcluidos = 15,
                            horasEstudadas = 25,
                            materias = listOf("Programação Android", "UI/UX Design")
                        ),
                        membros = mutableListOf("Membro 1", "Membro 2", "Membro 3")
                    )
                    GrupoEstudosScreen2(grupoEstudos2 = grupoEstudos2)
                }
            }
        }
    }
}

data class GrupoEstudosDados2(
    val tema: String,
    var fotoGrupo: Int,
    var estatisticas: Estatisticas2 = Estatisticas2(),
    var membros: MutableList<String> = mutableListOf()
) {
    data class Estatisticas2(
        var objetivosConcluidos: Int = 0,
        var horasEstudadas: Int = 0,
        var materias: List<String> = listOf()
    )
}

@Composable
fun GrupoEstudosScreen2(grupoEstudos2: GrupoEstudosDados2) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = grupoEstudos2.fotoGrupo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Tema do grupo: ${grupoEstudos2.tema}",
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
            IconWithTextDesafio2(Icons.Default.Check, "${grupoEstudos2.estatisticas.objetivosConcluidos} Objetivos Concluídos")
            Spacer(modifier = Modifier.width(16.dp))
            IconWithTextDesafio2(Icons.Default.Check, "${grupoEstudos2.estatisticas.horasEstudadas} Horas Estudadas")
        }

        Text(
            text = "Matérias: ${grupoEstudos2.estatisticas.materias.joinToString(", ")}",
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
            items(grupoEstudos2.membros) { membro ->
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
fun IconWithTextDesafio2(icon: ImageVector, text: String) {
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
fun GrupoEstudosPreview2() {
    StudyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val grupoEstudos2 = GrupoEstudosDados2(
                tema = "Conhecimentos sobre Android",
                fotoGrupo = technology,
                estatisticas = GrupoEstudosDados2.Estatisticas2(
                    objetivosConcluidos = 15,
                    horasEstudadas = 25,
                    materias = listOf("Programação Android", "UI/UX Design")
                ),
                membros = mutableListOf("Membro 1", "Membro 2", "Membro 3")
            )
            GrupoEstudosScreen2(grupoEstudos2 = grupoEstudos2)
        }
    }
}

@Preview
@Composable
fun GrupoEstudosPreviewWrapper2() {
    GrupoEstudosPreview2()
}
