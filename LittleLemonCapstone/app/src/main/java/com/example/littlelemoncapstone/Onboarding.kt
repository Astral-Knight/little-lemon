package com.example.littlelemoncapstone

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemoncapstone.ui.theme.LittleLemonCapstoneTheme
import com.example.littlelemoncapstone.ui.theme.highlightGrey
import com.example.littlelemoncapstone.ui.theme.primaryGreen
import com.example.littlelemoncapstone.ui.theme.primaryYellow

@Composable
fun Onboarding(navHostController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("Little Lemon", Context.MODE_PRIVATE)

    var firstName by remember {
        mutableStateOf("") }
    var lastName by remember {
        mutableStateOf("") }
    var email by remember {
        mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(200.dp)
                .padding(top = 10.dp) )
        Row (modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(color = primaryGreen)) {
            Text(
                text = "Welcome! Let's get to know you",
                style = MaterialTheme.typography.bodyLarge,
                color = highlightGrey,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp)
                )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(text ="Personal Information",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start)

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = firstName,
            onValueChange = {firstName = it},
            label = { Text("First Name", style = MaterialTheme.typography.bodySmall) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name", style = MaterialTheme.typography.bodySmall) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email", style = MaterialTheme.typography.bodySmall) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
               if (firstName.isBlank() || lastName.isBlank() || email.isBlank()) {
               Toast.makeText(context, "Registration is unsuccessful. Please enter all data.",
                   Toast.LENGTH_SHORT).show()
               } else {
                sharedPreferences.edit()
                     .putString("First Name", firstName)
                     .putString("Last Name", lastName)
                     .putString("email", email)
                     .apply()
                Toast.makeText(context, "Registration successful! Welcome to Little Lemon!",
                    Toast.LENGTH_SHORT).show()
                navHostController.navigate("home") {
                    popUpTo("onboarding") { inclusive = true }
                    launchSingleTop = true
                        }
                    }
               },
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(primaryYellow
            )) {

            Text("Register",
                style = MaterialTheme.typography.labelLarge)
        }

    }
}



@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    LittleLemonCapstoneTheme {
        Onboarding(navHostController = rememberNavController())
    }
}