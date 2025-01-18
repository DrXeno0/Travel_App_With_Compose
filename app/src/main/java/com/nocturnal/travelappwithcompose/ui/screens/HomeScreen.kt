package com.nocturnal.travelappwithcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nocturnal.travelappwithcompose.R
import com.nocturnal.travelappwithcompose.ui.theme.PurplePrimary


data class travelItem(val image: Int, val title: String)

val travelItems = listOf(
    travelItem(R.drawable.red_fort, "Places"),
    travelItem(R.drawable.plane, "Flights"),
    travelItem(R.drawable.train, "Trains"),
    travelItem(R.drawable.bus_stop, "Buses"),
    travelItem(R.drawable.taxi, "Taxi"),
)


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableStateOf(travelItems[0]) }
    var searchText by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(-10.dp)) {
            Text(
                text = "Good Morning, Shreya....",
                style = TextStyle(
                    fontSize = 21.65.sp,
                    fontFamily = FontFamily(Font(R.font.jaldi)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                ), modifier = Modifier.padding(0.dp)
            )
            Text(
                text = "Make plan for the weekend",
                modifier = Modifier.padding(0.dp),
                style = TextStyle(
                    fontSize = 21.65.sp,
                    fontFamily = FontFamily(Font(R.font.jaldi_bold)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000)
                )
            )

        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier.wrapContentHeight()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.wrapContentHeight(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)


            ) {
                TextField(
                    value = searchText,
                    onValueChange = {searchText = it},
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFCACACA),
                            shape = RoundedCornerShape(6.dp)
                        ),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.search_icon),
                            contentDescription = "Search Icon",
                            tint = Color.Gray
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Blue
                    ),
                    textStyle = TextStyle(fontSize = 16.sp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    )
                )


                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(56.dp)
                        .background(PurplePrimary, shape = RoundedCornerShape(12.dp))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.toggle_setting_icon),
                        contentDescription = "Toggle option",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(travelItems.size) {
                TravelItem(item = travelItems[it]
                    , isSelected = selectedItem == travelItems[it],
                    onClick = { selectedItem = travelItems[it] }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            item {

            }
        }


    }


}


@Preview
@Composable
fun TravelItem(item: travelItem = travelItem(R.drawable.taxi, "taxi"), isSelected : Boolean = false,onClick: () -> Unit = {}) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier.then(
                if (isSelected) Modifier.shadow(
                    elevation = 8.dp,
                    spotColor = Color(0xFF000000),
                    ambientColor = Color(0xFF000000),
                    shape = CircleShape
                ) else Modifier
            )

        ) {
            Box(

                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clickable { onClick()}
                    .background(Color.White, shape = CircleShape)
                    .size(70.dp)
                    .then(
                        if (isSelected) Modifier
                            .border(
                                width = 2.dp,
                                color = PurplePrimary,
                                shape = CircleShape
                            )
                        else Modifier
                    )
            ) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = item.title,
                    modifier = Modifier.size(40.dp)


                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            item.title, style = TextStyle(
                fontSize = 12.sp,
                fontFamily = if (isSelected) FontFamily(Font(R.font.poppins_bold)) else FontFamily(
                    Font(R.font.poppins)
                ),
                fontWeight = FontWeight(400),
                color = if (isSelected) Color(0xFF000000) else Color(0xFF848484),

                )
        )

    }
}