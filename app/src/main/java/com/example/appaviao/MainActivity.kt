package com.example.appaviao

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    MyApp()
                }
            }
        }
    }
}

@Composable
private fun Login(user: String, onSuccess: () -> Unit, onUserChange: (String) -> Unit) {
    /*val nameState = remember { mutableStateOf("") }
    val passState = remember { mutableStateOf("") }*/
    var userState by remember {
        mutableStateOf("")
    }
    var passwordState by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
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
                value = user,
                onValueChange = { onUserChange(it) },
                label = { Text(text = "usuário") })
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = passwordState,
                onValueChange = { passwordState = it },
                label = { Text(text = "Senha") })

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                if (user.equals("Ricardo") && passwordState.equals("1234")) {
                    onSuccess()
                    Toast.makeText(context, "Login ok", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Login inválido", Toast.LENGTH_LONG).show()
                }
            }, modifier = Modifier.fillMaxWidth()) {
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

@Composable
fun Welcome(user: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Olá ${user}",
            style = MaterialTheme.typography.h4
        )
    }
}

@Composable
fun MyApp() {
    var isLogged by remember {
        mutableStateOf(false)
    }
    var userState by remember {
        mutableStateOf("")
    }

    if (isLogged) {
        Welcome(user = userState)
    } else {
        Login(userState, onUserChange = {
            userState = it
        },
            onSuccess = {
                isLogged = true
            })
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPessoa() {

    AppAviaoTheme {
    MyApp()
    }
}
