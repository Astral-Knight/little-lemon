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
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
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
import androidx.navigation.NavController
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



@Composable
fun Home(navController: NavController, database: AppDatabase) {

        val menuItemsDatabase by database.menuItemDao().getAll().observeAsState(initial = emptyList())
        Column {
                com.example.littlelemoncapstone.TopAppBar(navController)
                HeroSection(menuItemsDatabase)
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroSection(menuItemsLocal: List<MenuItemRoom>) {
        var menuItems = menuItemsLocal
        var selectedCategory by remember { mutableStateOf("") }

                Column(
                        modifier = Modifier
                                .background(color = primaryGreen)
                                .padding(start = 12.dp, end = 12.dp, top = 12.dp)
                ) {

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
                                                .size(100.dp)


                                )
                        }
                        var searchPhrase by remember {
                                mutableStateOf("")
                        }
                        OutlinedTextField(
                                value = searchPhrase,
                                onValueChange = { searchPhrase = it },
                                label = {
                                        Text(
                                                "Enter Search Phrase",
                                                style = MaterialTheme.typography.bodySmall
                                        )
                                },
                                modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 20.dp, bottom = 20.dp),
                                colors = TextFieldDefaults.colors(
                                        focusedContainerColor = Color.Transparent

                                )
                        )
                        if (searchPhrase.isNotEmpty()) {
                                menuItems = menuItems.filter {
                                        it.title.contains(
                                                searchPhrase,
                                                ignoreCase = true
                                        )
                                }
                        }
                }


                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                        Text(
                                text = "ORDER FOR DELIVERY!",
                                modifier = Modifier.padding(top = 30.dp),
                                color = highlightBlack,
                                fontWeight = FontWeight.ExtraBold,
                                style = MaterialTheme.typography.bodyMedium
                        )
                        val scrollState = rememberScrollState()
                        Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp, bottom = 10.dp)
                        ) {
                                Button(
                                        onClick = {selectedCategory = "Starters"},
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
                                        onClick = {selectedCategory = "Mains"},
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
                                        onClick = {selectedCategory = "Desserts"},
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
                                        onClick = {selectedCategory = "Drinks"},
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
                                if (selectedCategory.isNotEmpty()) {
                                        menuItems = menuItems.filter {
                                                it.category.contains(selectedCategory)
                                        }
                                }


                        }
                }
        MenuItems(menuItems)
        }



@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItems(items: List<MenuItemRoom>) {
        LazyColumn(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
        ) {
                items(
                        items = items,
                        itemContent = { menuItem ->
                                Row(
                                        modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(8.dp)
                                ) {
                                        Column {
                                                Text(text = menuItem.title, style = MaterialTheme.typography.titleMedium)
                                                Text(
                                                        text = menuItem.description, style = MaterialTheme.typography.bodySmall,
                                                        modifier = Modifier
                                                                .fillMaxWidth(0.75f)
                                                                .padding(top = 5.dp)
                                                                .padding(bottom = 5.dp)
                                                )
                                                Text(
                                                        text = "$%.2f".format(menuItem.price),
                                                        style = MaterialTheme.typography.bodySmall
                                                )
                                        }

                                        GlideImage(
                                                model = menuItem.image,
                                                contentDescription = "Menu Item Image",
                                                modifier = Modifier
                                                        .clip(RoundedCornerShape(10.dp))
                                        )
                                }
                        }
                )
        }
}


@Preview(showBackground = true)
@Composable
fun HomePreview() {
        val context = LocalContext.current
        val database = Room.databaseBuilder(context, AppDatabase::class.java, "littlelemon").build()
        LittleLemonCapstoneTheme {
                Home(navController = rememberNavController(), database = database)
        }
}
