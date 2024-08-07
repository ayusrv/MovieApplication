package com.example.movieapplication.navigation

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.movieapplication.R

@Composable
fun BannerScreen(navController: NavHostController) {
    val modifier = Modifier
    Box(
        modifier = modifier.fillMaxSize()
    ){
        Image(painter = rememberAsyncImagePainter(model = R.drawable.banner_image), contentDescription = "",
            modifier.fillMaxSize(), contentScale = ContentScale.Crop
        )

        Column(
            modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    color = Color.White.copy(0.4f),
                    RoundedCornerShape(20.dp)
                ) // Set the background color of the column to white with an opacity of 0.4
                .border(0.5.dp, Color.White, RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val offset = Offset(10.0f, 10f) // Set the offset of the text
            Text(
                text = "Enjoy the World of movies",
                modifier.padding(vertical = 25.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                style = TextStyle(
                    fontSize = 34.sp,
                    shadow = Shadow(
                        color = Color(0xFF073E58),
                        offset = offset, blurRadius = 3f
                    ),
                    fontFamily = FontFamily(Font(R.font.cinzel_decorative)),
                    textAlign = TextAlign.Center
                )
            )

            val linearGradientBrush = Brush.linearGradient(
                colors = listOf(
                    Color(0XFFB226E1),
                    Color(0XFFFC6603),
//                    Color(0XFF5995EE),
//                    Color(0XFF3D3535)
                ),
                start = Offset(10000f, 0f),
                end = Offset(0f, 10000f)
            )
            Button(
                onClick = {
                    navController.navigate("Home Screen")
                },
                modifier
                    .padding(bottom = 55.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.Gray.copy(0.8f),
                        RoundedCornerShape(16.dp)
                    )
                    .border(
                        BorderStroke(
                            3.dp,
                            linearGradientBrush
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            )
            {
                Text(
                    text = "Get In", style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.cinzel_decorative)),
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}