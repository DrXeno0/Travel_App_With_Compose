package com.nocturnal.travelappwithcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nocturnal.travelappwithcompose.R

@Preview
@Composable
fun JourneyItem(
    image: Int = R.drawable.default_image,
    discription: String = "Shimla Best Kept Seceret"
) {
    Box(
        modifier = Modifier

            .width(206.dp)
            .height(139.dp)
            .background(color = Color.White, shape = RoundedCornerShape(size = 8.dp))
    ) {

        Image(
            painter = painterResource(id = image),
            contentDescription = discription,
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp, 12.dp, 12.dp, bottom = 8.dp)
                .clip(shape = RoundedCornerShape(8.dp)),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop,

            )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp, 12.dp, 12.dp, bottom = 8.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(
                    brush = Brush.verticalGradient(
                        0.5f to Color(0x00000000), 1f to COLORS.random()

                    )

                )
        )


        Text(
            text = discription,
            modifier = Modifier
                .padding(18.dp, 18.dp, 18.dp, bottom = 14.dp)
                .align(androidx.compose.ui.Alignment.BottomStart),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),

                )
        )


    }


}

val COLORS = listOf(
    Color(0xFF674DEE),
    Color(0xFFE57373),
    Color(0xFFEEB947),
)