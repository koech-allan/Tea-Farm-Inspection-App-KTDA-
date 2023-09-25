@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.digitalfarminspectionapp.ui.theme.pages.home

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.digitalfarminspectionapp.R
import com.example.digitalfarminspectionapp.navigation.ROUTE_ADD_GROWER
import com.example.digitalfarminspectionapp.navigation.ROUTE_GROWER_DETAILS
import com.example.digitalfarminspectionapp.ui.theme.DigitalFarmInspectionAppTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {


    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Column(modifier = Modifier
            .fillMaxWidth().background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "Tea Farm Inspection App",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
        }


        Spacer(modifier = Modifier.height(15.dp))


        Image(
            painter = painterResource(id = R.drawable.ktda),
            contentDescription = null,
            modifier = Modifier.height(110.dp).width(210.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))


//Start of text
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),


        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth().padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null,
                    modifier = Modifier.height(50.dp).width(50.dp)
                )
                Text(
                    text = "Our Company",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "The KTDA Holdings Ltd is a private holding company owned by small-holder tea farmers." +
                            " We are responsible for over 60% of the tea produced in Kenya.",
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.height(17.dp))


                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null,
                    modifier = Modifier.height(50.dp).width(50.dp)
                )
                Text(
                    text = "Our Teas",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "From planting to packaging, every process is expertly managed to ensure we produce" +
                            " the original high-quality Kenyan teas the world has grown to love.",
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.height(17.dp))


                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null,
                    modifier = Modifier.height(50.dp).width(50.dp)
                )
                Text(
                    text = "Sustainability",
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Through continuously improving our processes, we strive to adhere to" +
                            " ethical standards for producing our tea throughout our value chain.",
                    color = Color.Black,
                )
            }
        }


        Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        navController.navigate(ROUTE_ADD_GROWER)
                    },
                    modifier = Modifier.height(45.dp).width(170.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(Color.Green)
                ) {
                    Text(
                        text = "Register Grower",
                        color = Color.Black,
                        fontSize = 15.sp,

                    )
                }
                Spacer(modifier = Modifier.width(15.dp))

                Button(
                    onClick = {
                        navController.navigate(ROUTE_GROWER_DETAILS)
                    },
                    modifier = Modifier.height(45.dp).width(170.dp),
                    shape =CircleShape,
                    colors = ButtonDefaults.buttonColors(Color.Green)
                ) {
                    Text(
                        text = "Grower Details",
                        color = Color.Black,
                        fontSize = 15.sp,

                    )
                }

            }



//     end of text


//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            Button(
//                onClick = {
//                    navController.navigate(ROUTE_ADD_GROWER)
//                },
//                modifier = Modifier.height(200.dp).width(150.dp),
//                shape = RectangleShape,
//                colors = ButtonDefaults.buttonColors(Color.Green)
//            ) {
//                Text(
//                    text = "Register Grower",
//                    color = Color.Black,
//                    fontSize = 25.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//            Spacer(modifier = Modifier.width(50.dp))
//
//            Button(
//                onClick = {
//                    navController.navigate(ROUTE_UPDATE_GROWER)
//                },
//                modifier = Modifier.height(200.dp).width(150.dp),
//                shape = RectangleShape
//            ) {
//                Text(
//                    text = "Update Grower",
//                    color = Color.Yellow,
//                    fontSize = 25.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//
//        }
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            Button(
//                onClick = {
//                    navController.navigate(ROUTE_GROWER_DETAILS)
//                },
//                modifier = Modifier.height(180.dp).width(150.dp),
//                shape = RectangleShape
//            ) {
//                Text(
//                    text = "Grower Details",
//                    color = Color.Yellow,
//                    fontSize = 25.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//            Spacer(modifier = Modifier.width(50.dp))
//
//            Button(
//                onClick = { /*TODO*/ },
//                modifier = Modifier.height(180.dp).width(150.dp),
//                shape = RectangleShape,
//            ) {
//                Text(
//                    text = "Update Grower",
//                    color = Color.Yellow,
//                    fontSize = 25.sp,
//                    fontWeight = FontWeight.Bold,
//                )
//            }
//
//        }
//
//        Spacer(modifier = Modifier.height(20.dp))

//        Row(
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            Button(
//                onClick = { /*TODO*/ },
//                modifier = Modifier.height(180.dp).width(150.dp),
//                shape = RectangleShape,
//                colors = ButtonDefaults.buttonColors(Color.LightGray)
//            ) {
//                Text(
//                    text = "Register Grower",
//                    color = Color.Yellow,
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//            Spacer(modifier = Modifier.width(50.dp))
//
//            Button(
//                onClick = { /*TODO*/ },
//                modifier = Modifier.height(180.dp).width(150.dp),
//                shape = RectangleShape,
//                colors = ButtonDefaults.buttonColors(Color.DarkGray)
//            ) {
//                Text(
//                    text = "Update Grower",
//                    color = Color.Yellow,
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//
//        }

    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreview() {
    DigitalFarmInspectionAppTheme() {
        HomeScreen(rememberNavController())
    }


}



