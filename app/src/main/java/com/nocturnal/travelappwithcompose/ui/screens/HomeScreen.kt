package com.nocturnal.travelappwithcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.nocturnal.travelappwithcompose.ui.screens.pages.BookingForm


data class travelItem(val image: Int, val title: String)

val travelItems = listOf(
    travelItem(R.drawable.red_fort, "Places"),
    travelItem(R.drawable.plane, "Flights"),
    travelItem(R.drawable.train, "Trains"),
    travelItem(R.drawable.bus_stop, "Buses"),
    travelItem(R.drawable.taxi, "Taxi"),
)




@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var searchText by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
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
        Row(
            modifier = Modifier.height(56.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                label = {
                    Text("Search places")
                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = "Search Icon",
                        tint = Color.Gray
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Gray,
                ),
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
                    .padding(8.dp)
                    .background(Color(0xFF674DEE), shape = RoundedCornerShape(12.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.toggle_setting_icon),
                    contentDescription = "Toggle option",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ){
            items(travelItems.size){
                TravelItem(item = travelItems[it])
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            item {
                BookingForm()
            }
        }



    }


}



@Composable
fun TravelItem(item: travelItem) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = item.title,

            modifier = Modifier.background(Color.White, shape = CircleShape).padding(20.dp).size(46.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(item.title, style = TextStyle())

    }
}