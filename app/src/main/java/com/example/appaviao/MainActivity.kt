package com.example.appaviao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appaviao.ui.theme.AppAviaoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppAviaoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    Login()
                }
            }
        }
    }
}

@Composable
private fun Login() {
    val nameState =  remember { mutableStateOf("") }
    val passState =  remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.aviao2),
            contentDescription = "Logo",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),

            ) {

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = nameState.value,
                onValueChange = { textoRecebido -> nameState.value = textoRecebido },
                label = { Text(text = "usuário") })
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = passState.value,
                onValueChange = { textoRecebido -> passState.value = textoRecebido },
                label = { Text(text = "Senha") })
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.height(8.dp))
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Esqueceu a senha?")
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Criar nova conta")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPessoa() {
    AppAviaoTheme {
        Login()
    }
}


























