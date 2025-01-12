package com.nocturnal.travelappwithcompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nocturnal.travelappwithcompose.R


data class BottomBarItem(val icon: Int, val title: String)

val bottomBarItems = listOf(
    BottomBarItem(R.drawable.home_icon, "Home"),
    BottomBarItem(R.drawable.brief_case_icon, "Voyage"),
    BottomBarItem(R.drawable.book_mark_icon, "Bookmark"),
    BottomBarItem(R.drawable.profile_icon, "Profile")
)

@Preview
@Composable
fun BottomBar(modifier: Modifier = Modifier.background(Color.White)) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround

    ) {
        for (item in bottomBarItems) {
            BottomBarItem(item = item)
        }

    }
}

@Composable
fun BottomBarItem(item: BottomBarItem, modifier: Modifier = Modifier,isSelected: Boolean = false) {
    var isSelected = isSelected

    Icon(
        painter = painterResource(id = item.icon),
        contentDescription = item.title,
        tint = if (isSelected) androidx.compose.ui.graphics.Color.White else androidx.compose.ui.graphics.Color.Gray,
        modifier = modifier
            .clickable { isSelected = !isSelected}
            .then(
                if (isSelected) {
                    Modifier
                        .background(
                            Color(0xFF674DEE),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(10.dp)
                        .shadow(
                            4.dp,
                            spotColor = Color(0x26000000), ambientColor = Color(0x26000000)
                        )
                } else {
                    Modifier
                }
            )
    )
}

