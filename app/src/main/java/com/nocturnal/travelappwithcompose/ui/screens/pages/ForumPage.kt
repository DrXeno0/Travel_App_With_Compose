package com.nocturnal.travelappwithcompose.ui.screens.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nocturnal.travelappwithcompose.R
import com.nocturnal.travelappwithcompose.ui.theme.PurplePrimary

@Preview
@Composable
fun ForumView() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 16.dp, bottom = 26.dp)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Book your Flight",
                style = TextStyle(
                    fontSize = 18.56.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),

                    )
            )


        }
    }
}


@Preview
@Composable
fun FlightType(modifier: Modifier = Modifier) {

    val flightTypes = listOf("One-Way", "Round Trip", "Multi-City")
    var selectedFlightType by remember { mutableStateOf(flightTypes[0]) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(36.dp)
            .background(Color(0xFFF9F9F9), shape = RoundedCornerShape(26.dp))
            .clip(RoundedCornerShape(26.dp))
    ) {
        Row(Modifier.fillMaxWidth()) {
            flightTypes.forEach { flightType ->
                FlightTypeItem(
                    text = flightType,
                    isSelected = selectedFlightType == flightType,
                    onItemClick = { selectedFlightType = flightType },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun FlightTypeItem(
    text: String,
    isSelected: Boolean,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val backgroundColor = if (isSelected) PurplePrimary else Color(0xFFF9F9F9)
    val textColor = if (isSelected) Color.White else Color(0xFF867F7F)

    Row(
        modifier = modifier
            .fillMaxHeight()
            .background(backgroundColor)
            .clickable { onItemClick() }
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            color = textColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),

            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.poppins)),
            fontWeight = FontWeight(400),

            )
    }
}