package pdm.study

// Importações necessárias
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri

data class Membro(val nome: String, val fotoUrl: String, val mensagem: String)

class TelaMotivacaoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaMotivacao()
        }
    }
}

@Composable
fun TelaMotivacao() {
    var mensagem by remember { mutableStateOf(TextFieldValue()) }
    var fotoUrl by remember { mutableStateOf(TextFieldValue()) }

    val membros = remember { mutableStateListOf<Membro>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Compartilhe uma mensagem motivacional com o grupo!",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        BasicTextField(
            value = mensagem,
            onValueChange = {
                mensagem = it
            },
            textStyle = TextStyle(fontSize = 16.sp),
            maxLines = 3,
            singleLine = false,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp)
                .clip(MaterialTheme.shapes.medium)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "URL da sua foto de motivação:",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        BasicTextField(
            value = fotoUrl,
            onValueChange = {
                fotoUrl = it
            },
            textStyle = TextStyle(fontSize = 16.sp),
            maxLines = 1,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp)
                .clip(MaterialTheme.shapes.medium)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (fotoUrl.text.isNotBlank() && mensagem.text.isNotBlank()) {
                    membros.add(Membro("Usuário", fotoUrl.text, mensagem.text))
                    mensagem = TextFieldValue()
                    fotoUrl = TextFieldValue()
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Enviar", fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Membros do grupo:",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(membros) { membro ->
                MembroItem(membro = membro)
                Divider()
            }
        }
    }
}

@Composable
fun MembroItem(membro: Membro) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        LoadNetworkImage(url = membro.fotoUrl, modifier = Modifier.size(50.dp).clip(MaterialTheme.shapes.medium))
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "${membro.nome}: ${membro.mensagem}",
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun LoadNetworkImage(url: String, modifier: Modifier = Modifier) {
    var imageBitmap by remember { mutableStateOf<Bitmap?>(null) }

    val imageUrl = URL(url)
    val httpURLConnection: HttpURLConnection = imageUrl.openConnection() as HttpURLConnection
    httpURLConnection.doInput = true
    httpURLConnection.connect()
    val input: InputStream = httpURLConnection.inputStream
    val drawable = Drawable.createFromStream(input, null)
    val bitmap = (drawable as BitmapDrawable).bitmap

    if (bitmap != null) {
        imageBitmap = bitmap
    }

    imageBitmap?.asImageBitmap()?.let {
        Image(
            bitmap = it,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    }
}
