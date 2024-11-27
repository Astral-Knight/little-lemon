package com.example.littlelemoncapstone

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.littlelemoncapstone.ui.theme.primaryYellow


@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences(USER_PROFILE, Context.MODE_PRIVATE)

    val firstName = sharedPreferences.getString(FIRST_NAME, "")
    val lastName = sharedPreferences.getString(LAST_NAME, "")
    val email = sharedPreferences.getString(EMAIL, "")

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(200.dp)
                .padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Personal Information",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "First Name: $firstName",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp),
            textAlign = TextAlign.Start)

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Last Name: $lastName",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp),
            textAlign = TextAlign.Start)

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Email: $email",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp),
            textAlign = TextAlign.Start)

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                sharedPreferences.edit().clear().apply()
                Toast.makeText(context, "Logged Out Successfully!", Toast.LENGTH_SHORT).show()
                navController.navigate(Onboarding.route)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                primaryYellow)
        ) {
            Text(text = "Log Out", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

 @Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    LittleLemonCapstoneTheme {
        Profile(navController = rememberNavController())
    }
}

