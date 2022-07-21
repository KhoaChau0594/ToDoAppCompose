package com.khoachau.todoappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khoachau.todoappcompose.ui.theme.Gray100
import com.khoachau.todoappcompose.ui.theme.Gray200
import com.khoachau.todoappcompose.ui.theme.ToDoAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppComposeTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Surface {
        Column {
            AppHeader()
            Divider(modifier = Modifier.padding(start = 6.dp, end = 6.dp), color = Gray100)
            AppBody()
        }
    }
}

@Composable
fun AppHeader() {
    Row(
        modifier = Modifier
            .padding(start = 18.dp, top = 16.dp, bottom = 16.dp, end = 18.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Today", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(8.dp))
        DatePicker(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.height(20.dp),
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = ""
        )
    }
}

@Composable
fun DatePicker(modifier: Modifier) {
    Row(modifier) {
        Text(text = "January 28", color = Gray200)
        Image(
            modifier = Modifier
                .height(14.dp)
                .width(16.dp)
                .align(Alignment.CenterVertically),
            painter = painterResource(id = R.drawable.ic_baseline_arrow_drop_down_24),
            contentDescription = "",
        )
    }
}

@Composable
fun AppBody() {
    TaskItem()
}

@Preview
@Composable
fun HeaderPreview() {
    ToDoAppComposeTheme {
        AppHeader()
    }
}

@Preview
@Composable
fun BodyPreview() {
    ToDoAppComposeTheme {
        AppBody()
    }
}