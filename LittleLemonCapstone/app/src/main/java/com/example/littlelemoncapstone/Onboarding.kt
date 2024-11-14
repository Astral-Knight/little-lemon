package com.example.littlelemoncapstone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemoncapstone.ui.theme.highlightGrey
import com.example.littlelemoncapstone.ui.theme.primaryGreen

@Composable
fun Onboarding() {

    var firstName by remember {
        mutableStateOf("") }
    var lastName by remember {
        mutableStateOf("") }
    var email by remember {
        mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally ) {
     // Header with logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 16.dp) )
        Row (modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(color = primaryGreen)) {
            Text(
                text = "Let's get to Know you",
                style = MaterialTheme.typography.titleLarge,
                color = highlightGrey,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                )
        }


        OutlinedTextField(
            value = firstName,
            onValueChange = {firstName = it},
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth()
        )


        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = { /* Handle button click */ },
            modifier = Modifier.padding(top = 16.dp)) {
            Text("Register")
        }

    }
}



@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    Onboarding()
}