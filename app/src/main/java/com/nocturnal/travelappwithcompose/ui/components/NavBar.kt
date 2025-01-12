package com.nocturnal.travelappwithcompose.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nocturnal.travelappwithcompose.R

@Composable
fun NavBar() {
    NavigationBar(containerColor = MaterialTheme.colorScheme.surfaceVariant) {

    }
}

@Preview
@Composable
fun NavBarMenuButton(onClick: () -> Unit = {}) {
    IconButton(onClick = {
        onClick()

    }) {
        Icon(
            painter = painterResource(id = R.drawable.menu_icon), contentDescription = "menu button",tint = Color(0xFF674DEE)
        )
    }
}

@Preview
@Composable
fun ProfileButton(imageResource: Int = R.drawable.profile_image, onClick: () -> Unit = {}, modifier: Modifier = Modifier) {

            Image(
            painter = painterResource(id = imageResource),
            contentDescription = "profile picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(RoundedCornerShape(7.dp)).height(46.dp).width(46.dp).clickable { onClick() },
        )


}
@Preview
@Composable
fun Appbar(){
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        NavBarMenuButton()
        Spacer(modifier = Modifier.weight(1f))
        ProfileButton()

    }
}