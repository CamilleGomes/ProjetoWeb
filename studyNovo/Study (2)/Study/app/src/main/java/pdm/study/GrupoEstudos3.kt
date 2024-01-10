package pdm.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pdm.study.ui.theme.StudyTheme

class GrupoEstudos3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val grupoEstudos3 = GrupoEstudosDados3(
                        tema = "Design UI/UX",
                        fotoGrupo = R.drawable.ux_design, // Substitua "design" pelo nome correto do recurso de imagem
                        estatisticas = GrupoEstudosDados3.Estatisticas3(
                            objetivosConcluidos = 20,
                            horasEstudadas = 30,
                            ferramentas = listOf("Figma", "Sketch", "Adobe XD")
                        ),
                        membros = mutableListOf("Membro 1", "Membro 2", "Membro 3")
                    )
                    GrupoEstudosScreen3(grupoEstudos3 = grupoEstudos3)
                }
            }
        }
    }
}

data class GrupoEstudosDados3(
    val tema: String,
    var fotoGrupo: Int,
    var estatisticas: Estatisticas3 = Estatisticas3(),
    var membros: MutableList<String> = mutableListOf()
) {
    data class Estatisticas3(
        var objetivosConcluidos: Int = 0,
        var horasEstudadas: Int = 0,
        var ferramentas: List<String> = listOf()
    )
}

@Composable
fun GrupoEstudosScreen3(grupoEstudos3: GrupoEstudosDados3) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = grupoEstudos3.fotoGrupo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Tema do grupo: ${grupoEstudos3.tema}",
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
            IconWithTextDesafio3(Icons.Default.Check, "${grupoEstudos3.estatisticas.objetivosConcluidos} Objetivos Concluídos")
            Spacer(modifier = Modifier.width(16.dp))
            IconWithTextDesafio3(Icons.Default.Check, "${grupoEstudos3.estatisticas.horasEstudadas} Horas Estudadas")
        }

        Text(
            text = "Ferramentas: ${grupoEstudos3.estatisticas.ferramentas.joinToString(", ")}",
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
            items(grupoEstudos3.membros) { membro ->
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
fun IconWithTextDesafio3(icon: ImageVector, text: String) {
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
