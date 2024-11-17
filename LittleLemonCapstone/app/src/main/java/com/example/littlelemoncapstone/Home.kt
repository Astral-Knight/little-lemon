package com.example.littlelemoncapstone

import android.view.MenuItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemoncapstone.ui.theme.LittleLemonCapstoneTheme
import com.example.littlelemoncapstone.ui.theme.highlightBlack
import com.example.littlelemoncapstone.ui.theme.highlightGrey
import com.example.littlelemoncapstone.ui.theme.primaryGreen
import com.example.littlelemoncapstone.ui.theme.primaryYellow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController) {
        val context = LocalContext.current
        val database = remember {
                Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "menu-database"
                ).build()
        }
        val menuItemsDatabase by database.menuItemDao().getAll().observeAsState(emptyList())
        Column (modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())) {

        Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.size(30.dp))
                Image(painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(150.dp))

                IconButton(onClick = { navController.navigate(Profile.route) }) {
                        Image(
                                painter = painterResource(id = R.drawable.profile),
                                contentDescription = "Profile",
                                modifier = Modifier.size(150.dp) ) }
        }

        Column( modifier = Modifier
                .background(color = primaryGreen)
                .padding(start = 12.dp, end = 12.dp, top = 12.dp)) {

                Text(
                        text = "Little Lemon",
                        style = MaterialTheme.typography.titleLarge,
                        color = primaryYellow
                )
                Text(
                        text = "Chicago",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = highlightGrey
                )
                Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp)
                ) {
                        Text(
                                text = "We are a family owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier
                                        .padding(end = 10.dp)
                                        .fillMaxWidth(0.6f),
                                color = highlightGrey
                        )
                        Image(
                                painter = painterResource(id = R.drawable.hero_image),
                                contentDescription = "Hero Image",
                                modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .size(200.dp)



                        )
                }
                var searchPhrase by remember {
                        mutableStateOf("")
                }
                        OutlinedTextField(
                                value = "",
                                onValueChange = {},
                                label = { Text("Enter Search Phrase",
                                        style = MaterialTheme.typography.bodySmall)
                                                },
                                modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 20.dp, bottom = 20.dp),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                        containerColor = highlightGrey,
                                        focusedBorderColor = highlightGrey,
                                        unfocusedBorderColor = highlightGrey,
                                        cursorColor = highlightGrey))
                                }


        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                        text = "ORDER FOR DELIVERY!",
                        modifier = Modifier.padding(top = 30.dp),
                        color = highlightBlack,
                        fontWeight = FontWeight.ExtraBold,
                        style = MaterialTheme.typography.bodyMedium
                )
                Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 10.dp)
                ) {
                        Button(
                                onClick = {},
                                modifier = Modifier.height(40.dp),
                                colors = ButtonDefaults.buttonColors(highlightGrey),
                                shape = RoundedCornerShape(15.dp)
                        ) {
                                Text(
                                        text = "Starters",
                                        fontWeight = FontWeight.Bold,
                                        color = highlightBlack,
                                        style = MaterialTheme.typography.bodySmall
                                )
                        }

                        Button(
                                onClick = {},
                                modifier = Modifier.height(40.dp),
                                colors = ButtonDefaults.buttonColors(highlightGrey),
                                shape = RoundedCornerShape(15.dp)
                        ) {
                                Text(
                                        text = "Mains",
                                        fontWeight = FontWeight.Bold,
                                        color = highlightBlack,
                                        style = MaterialTheme.typography.bodySmall
                                )
                        }

                        Button(
                                onClick = {},
                                modifier = Modifier.height(40.dp),
                                colors = ButtonDefaults.buttonColors(highlightGrey),
                                shape = RoundedCornerShape(15.dp)
                        ) {
                                Text(
                                        text = "Desserts",
                                        fontWeight = FontWeight.Bold,
                                        color = highlightBlack,
                                        style = MaterialTheme.typography.bodySmall
                                )
                        }

                        Button(
                                onClick = {},
                                modifier = Modifier.height(40.dp),
                                colors = ButtonDefaults.buttonColors(highlightGrey),
                                shape = RoundedCornerShape(15.dp)
                        ) {
                                Text(
                                        text = "Drinks",
                                        fontWeight = FontWeight.Bold,
                                        color = highlightBlack,
                                        style = MaterialTheme.typography.bodySmall
                                )
                        }
                }
        }

        }
        MenuItems(menuItemsList = menuItemsDatabase)
}


@Composable
fun MenuItems(menuItemsList: List<MenuItemRoom>) {
        LazyColumn(
                modifier = Modifier
                        .fillMaxHeight()
                        .padding(16.dp)
        ) {
                items(items = menuItemsList, itemContent = { menuItem ->
                        MenuItem(menuItem)
                })
        }
}
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItem(menuItem: MenuItemRoom) {
                        Divider(
                                thickness = 2.dp,
                                color = Color(0xFFDDDDDD),
                                modifier = Modifier.padding(vertical = 15.dp)
                        )
                        Column(verticalArrangement = Arrangement.SpaceBetween) {
                                Text(
                                        text = menuItem.title,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp
                                )
                                Row(modifier = Modifier.fillMaxSize()) {
                                        Column(
                                                modifier = Modifier
                                                        .weight(0.5f)
                                                        .fillMaxHeight(),
                                                verticalArrangement = Arrangement.SpaceBetween
                                        ) {
                                                Text(
                                                        text = menuItem.description,
                                                        fontSize = 13.sp,
                                                        color = Color.Gray
                                                )
                                                Text(
                                                        text = "$${menuItem.price}",
                                                        fontWeight = FontWeight.SemiBold,
                                                        fontSize = 15.sp,
                                                        color = Color.Gray
                                                )
                                        }
                                        GlideImage(
                                                model = (menuItem.image),
                                                contentDescription = menuItem.title,
                                                modifier = Modifier
                                                        .padding(start = 15.dp)
                                                        .size(100.dp),
                                                contentScale = ContentScale.Crop,
                                        )
                                }
                        }
                }
        /*Column(modifier = Modifier.padding(16.dp)) {
                Text(text = menuItem.title, style = MaterialTheme.typography.bodySmall)
                Text(text = "${menuItem.price}", style = MaterialTheme.typography.bodySmall)
                Text(text = menuItem.description, style = MaterialTheme.typography.bodySmall)
                GlideImage(
                        model = menuItem.image,
                        contentDescription = menuItem.title,
                        modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .padding(top = 8.dp)*/


@Preview(showBackground = true)
@Composable
fun HomePreview() {
        LittleLemonCapstoneTheme {
                Home(navController = rememberNavController())
        }
}
