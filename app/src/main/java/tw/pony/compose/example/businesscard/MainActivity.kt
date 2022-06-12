package tw.pony.compose.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tw.pony.compose.example.businesscard.ui.theme.ComposeBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBusinessCardTheme {
        BusinessCard()
    }
}

@Composable
fun BusinessCard() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF0E3948)),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        NameAndTitle()
        UserInfo()
    }
}

@Composable
fun NameAndTitle() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "logo",
            modifier = Modifier.width(100.dp),
        )
        Text(
            text = "Pony Chen",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 36.sp
        )
        Text(
            text = "Android Developer Extraordinaire",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            color = Color(0xFF3ddc84),
            fontSize = 16.sp
        )
    }
}

//@Preview
@Composable
fun UserInfo() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        InfoItem(imageVector = Icons.Rounded.Phone, contentDescription = "phone", info = "+886 (02) 26557557")
        InfoItem(imageVector = Icons.Rounded.Share, contentDescription = "share", info = "@ponychen")
        InfoItem(imageVector = Icons.Rounded.Email, contentDescription = "email", info = "ponychen@kkbox.com")
    }
}

@Composable
fun InfoItem(imageVector: ImageVector, contentDescription: String?, info: String) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.White))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 0.dp, top = 4.dp, end = 0.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = Color(0xFF3ddc84),
            modifier = Modifier
                .padding(start = 40.dp, end = 16.dp)
        )
        Text(
            text = info,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp)
        )
    }
}