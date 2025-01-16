package com.nocturnal.travelappwithcompose.ui.screens.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nocturnal.travelappwithcompose.R
import com.nocturnal.travelappwithcompose.ui.components.openDatePickerDialog

@Preview
@Composable
fun BookingForm(
    modifier: Modifier = Modifier,
    selectedDate: String = "",
    onDateChange: (String) -> Unit = {},
    adultCount: Int = 0,
    childCount: Int = 0,
    onAdultCountChange: (Int) -> Unit = {},
    onChildCountChange: (Int) -> Unit = {}
) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("One Way", "Round Trip", "Multicity")
    val context = LocalContext.current
    var showDatePickerDialog by remember { mutableStateOf(false) }

    if (showDatePickerDialog) {
        openDatePickerDialog(context) { date ->
            onDateChange(date)
            showDatePickerDialog = true
        }
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Book your Flight",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF4F4F4), RoundedCornerShape(70.dp))
                    .padding(4.dp).clip(shape = RoundedCornerShape(70.dp))
            ) {
                tabs.forEachIndexed { index, title ->
                    Text(
                        text = title,
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                if (selectedTab == index) Color(0xFF674DEE) else Color.Transparent,
                                RoundedCornerShape(6.dp)
                            )
                            .padding(vertical = 8.dp)
                            .clickable { selectedTab = index },
                        color = if (selectedTab == index) Color.White else Color.Gray,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "From",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                fontWeight = FontWeight.Medium
            )
            OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                placeholder = { Text("Choose Departure from") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFE8E8E8),
                    focusedBorderColor = Color(0xFF674DEE)
                ),
                shape = RoundedCornerShape(8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .size(55.dp)
                            .background(Color(0xFF674DEE), CircleShape)
                            .padding(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.up_down_icon),
                            contentDescription = "Switch",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }

            Text(
                text = "To",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                fontWeight = FontWeight.Medium
            )
            OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                placeholder = { Text("Choose Arrival at") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFE8E8E8),
                    focusedBorderColor = Color(0xFF674DEE)
                ),
                shape = RoundedCornerShape(8.dp)
            )

            Text(
                text = "Departure Date",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 16.dp)
            )
            OutlinedTextField(
                value = selectedDate,
                onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { showDatePickerDialog = true },
                placeholder = { Text("Select Date") },
                readOnly = true,

                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Decimal
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFE8E8E8),
                    focusedBorderColor = Color(0xFF674DEE)
                ),
                shape = RoundedCornerShape(8.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                PassengerCounter(
                    label = "Adult (12+)",
                    count = adultCount,
                    onCountChange = onAdultCountChange,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                PassengerCounter(
                    label = "Child (2-12)",
                    count = childCount,
                    onCountChange = onChildCountChange,
                    modifier = Modifier.weight(1f)
                )
            }

            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .padding(8.dp)
                    .height(50.dp)
                    .fillMaxWidth(),
                border = BorderStroke(2.dp, Color(0xFF674DEE)),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Search Flight",
                    color = Color(0xFF674DEE),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
@Composable
fun PassengerCounter(
    label: String,
    count: Int,
    onCountChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(10.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black,
            fontWeight = FontWeight.Medium
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { if (count > 0) onCountChange(count - 1) },
                modifier = Modifier
                    .size(32.dp)
                    .background(Color(0xFF674DEE), RoundedCornerShape(8.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = "Decrease",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }

            Text(
                text = String.format("%02d", count),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )

            IconButton(
                onClick = { onCountChange(count + 1) },
                modifier = Modifier
                    .size(32.dp)
                    .background(Color(0xFF674DEE), RoundedCornerShape(8.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "Increase",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}