package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            BusinessCardTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    ) { innerPadding ->
                    AndriodLogoImage(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(Color(0xFF3ddc84))
                    )

                }
            }
        }
    }
}

@Composable
fun AndriodLogoImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .background(Color.Black)
            )
            NameTitleText(
                name = stringResource(R.string.name_text),
                title = stringResource(R.string.title_text),
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )
        }

        ContactInfoText(
            phoneNum = stringResource(R.string.phone_num_text),
            hashhtag = stringResource(R.string.hash_tag_text),
            email = stringResource(R.string.email_text),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(top = 16.dp,  bottom = 16.dp)
        )
    }
}

@Composable
fun NameTitleText(name: String, title: String, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )
}
}

@Composable
fun ContactInfoText(phoneNum: String, hashhtag: String, email: String, modifier: Modifier = Modifier) {
    val phone = painterResource(R.drawable.phone_24dp_78a75a)
    val share = painterResource(R.drawable.share_24dp_78a75a)
    val mail = painterResource(R.drawable.email_24dp_78a75a)
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,

    )
    {
        Row{
            Image(
                painter = phone,
                contentDescription = "Phone Icon"
            )
            Text(
                text = "\t" + phoneNum
            )
        }

        Row{
            Image(
                painter = share,
                contentDescription = "Share Icon"
            )
            Text(
                text = "\t"+hashhtag
            )
        }
        Row{
            Image(
                painter = mail,
                contentDescription = "Email Icon"
            )
            Text(
                text = "\t"+email
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        AndriodLogoImage(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3ddc84))
        )
    }
}