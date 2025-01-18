package com.nocturnal.travelappwithcompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nocturnal.travelappwithcompose.R
import com.nocturnal.travelappwithcompose.ui.theme.PurplePrimary


data class BottomBarItem(val icon: Int, val title: String)

val bottomBarItems = listOf(
    BottomBarItem(R.drawable.home_icon, "Home"),
    BottomBarItem(R.drawable.brief_case_icon, "Voyage"),
    BottomBarItem(R.drawable.book_mark_icon, "Bookmark"),
    BottomBarItem(R.drawable.profile_icon, "Profile")
)

@Preview
@Composable
fun NavigationBar(modifier: Modifier = Modifier.background(Color.White)) {
    var selectedItemType by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(85.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically

    ) {
        bottomBarItems.forEach { item ->
            val isSelected = selectedItemType == item.title
            BottomNavigationItem(
                item = item,
                isSelected = isSelected,
                onClick = {
                    selectedItemType = item.title

                }
            )
        }

    }
}

@Composable
fun BottomNavigationItem(item: BottomBarItem, modifier: Modifier = Modifier, isSelected: Boolean = false, onClick: () -> Unit = {}) {


    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(44.dp)
            .then(
                if (isSelected) Modifier.background(
                    PurplePrimary,
                    shape = RoundedCornerShape(12.dp)
                ) else Modifier
            )
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            tint = if (isSelected) androidx.compose.ui.graphics.Color.White else androidx.compose.ui.graphics.Color.Gray,
            modifier = modifier
                .clickable { onClick() }

        )
    }
}

