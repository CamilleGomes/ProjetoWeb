package pdm.study

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import pdm.study.ui.theme.Pessego
import pdm.study.ui.theme.StudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginPage(this)
                }
            }
        }
    }
}

@Composable
fun LoginPage(activity: ComponentActivity) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Study+",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 72.sp
            )
        )
        Spacer(modifier = Modifier.size(36.dp))
        Image(
            painter = painterResource(id = R.drawable.livro_rosto),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(0.5f)
                .aspectRatio(1.0f)
                .padding(16.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.size(100.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    activity.startActivity(
                        Intent(activity, ContaCadastrar::class.java).setFlags(
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
                        )
                    )
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.7f),
                colors = ButtonDefaults.buttonColors(Pessego)
            ) {
                Text("Cadastre-se",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                )
            }
            Button(
                onClick = {
                    activity.startActivity(
                        Intent(activity, ContaEntrar::class.java).setFlags(
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
                        )
                    )
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.7f),
                colors = ButtonDefaults.buttonColors(Pessego)
            ) {
                Text("Entrar",
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
fun MainActivityPreview() {
    val activity = MainActivity() // Substitua por sua própria Activity
    StudyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginPage(activity)
        }
    }
}

@Preview
@Composable
fun MainActivityPreviewWrapper() {
    MainActivityPreview()
}