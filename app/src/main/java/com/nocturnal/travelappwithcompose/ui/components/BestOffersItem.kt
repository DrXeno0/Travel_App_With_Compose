package com.nocturnal.travelappwithcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nocturnal.travelappwithcompose.R


@Preview
@Composable
fun BestOffersItem(
    image: Int = R.drawable.default_image,
    title: String = "Cupid's Gift for Couples",
    message: String = "Up to 30% OFF*",
    onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .width(304.dp)
            .height(178.99998.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.dp))
            .clip(shape = RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFFFFFFF))
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .width(280.dp)
                    .height(111.dp)
            ) {
                Image(
                    painter = painterResource(id = image),
                    "picture for the offer",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Row(verticalAlignment = Alignment.Bottom) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = title, style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            fontSize = 10.sp,
                            fontWeight = FontWeight(600),

                            )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        message,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.poppins_bold)),
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500)
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(1f))

                Text(text = "View Details",

                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF674DEE),

                        textDecoration = TextDecoration.Underline,
                    ),
                    modifier = Modifier.clickable { onClick })

            }
        }
    }
}