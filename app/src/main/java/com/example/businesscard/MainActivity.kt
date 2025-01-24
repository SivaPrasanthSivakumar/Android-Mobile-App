package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AndriodLogoImage(
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}

@Composable
fun AndriodLogoImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Box(modifier){
        Column(
            verticalArrangement = Arrangement.Center,
        ){
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            NameTitleText(
                name = stringResource(R.string.name_text),
                title = stringResource(R.string.title_text),
                modifier = Modifier
            )
            ContactInfoText(
                phoneNum= stringResource(R.string.phone_num_text),
                hashhtag= stringResource(R.string.hash_tag_text),
                email= stringResource(R.string.email_text),
                modifier= Modifier)
        }


    }

}
@Composable
fun NameTitleText(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier ,
        verticalArrangement = Arrangement.Center,
    )
    {
        Text(
            text = name
        )
        Text(
            text = title
        )
    }
}

@Composable
fun ContactInfoText(phoneNum: String, hashhtag: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize() ,
        verticalArrangement = Arrangement.Center,
    )
    {
        Text(
            text = phoneNum
        )
        Text(
            text = hashhtag
        )
        Text(
            text = email
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        AndriodLogoImage(modifier = Modifier)
    }
}