package pdm.study

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class GrupoEstudos(
    val tema: String,
    var fotoGrupo: Bitmap? = null,
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
fun GrupoEstudosScreen(grupoEstudos: GrupoEstudos) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        grupoEstudos.fotoGrupo?.let { bitmap ->
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )
        }

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
            IconWithText(Icons.Default.Check, "${grupoEstudos.estatisticas.objetivosConcluidos} Objetivos Concluídos")
            Spacer(modifier = Modifier.width(16.dp))
            IconWithText(Icons.Default.Check, "${grupoEstudos.estatisticas.horasEstudadas} Horas Estudadas")
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
fun GrupoEstudosScreenPreview(grupoEstudos: GrupoEstudos) {
    GrupoEstudosScreen(grupoEstudos = grupoEstudos)
}

@Preview(showBackground = true)
@Composable
fun GrupoEstudosScreenPreviewWrapper() {
    val sampleBitmap: Bitmap? = null // Substitua isso pelo seu bitmap real, se necessário
    val sampleGrupoEstudos = GrupoEstudos(
        tema = "Tema do Grupo de Estudos",
        fotoGrupo = sampleBitmap,
        estatisticas = GrupoEstudos.Estatisticas(
            objetivosConcluidos = 10,
            horasEstudadas = 20,
            materias = listOf("Matemática", "Física")
        ),
        membros = mutableListOf("Membro 1", "Membro 2", "Membro 3")
    )
    GrupoEstudosScreenPreview(grupoEstudos = sampleGrupoEstudos)
}
