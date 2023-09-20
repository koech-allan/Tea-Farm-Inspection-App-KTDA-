package com.example.digitalfarminspectionapp.ui.theme.pages.growers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.digitalfarminspectionapp.data.GrowerRepository
import com.example.digitalfarminspectionapp.models.Grower
import com.example.digitalfarminspectionapp.navigation.ROUTE_UPDATE_GROWER

@Composable
fun GrowerdetailsScreen(navController: NavHostController) {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            var context = LocalContext.current
            var growerRepository = GrowerRepository(navController,context)

            val emptyGrowerState = remember { mutableStateOf(Grower("","","","","","","")) }
            var emptyGrowersListState = remember { mutableStateListOf<Grower>() }

            var growers = growerRepository.viewGrower(emptyGrowerState, emptyGrowersListState)

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Column(modifier = Modifier
                    .fillMaxWidth().background(Color.Green),
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        text = "ALL GROWERS",
                        color = Color.Red,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(20.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))


                LazyColumn(){
                    items(growers.count()){
                        var growerName = growers.get(it).name
                        var growerNumber = growers.get(it).gnumber
                        var growerId = growers.get(it).idnumber
                        var phoneNumber = growers.get(it).phone
                        var numberofBushes = growers.get(it).bushes
                        var area = growers.get(it).garea
                        var id = growers.get(it).id
                        GrowerItem(
                            name = growerName,
                            gnumber = growerNumber,
                            idnumber = growerId,
                            phone = phoneNumber,
                            bushes = numberofBushes,
                            garea = area,
                            id = id,
                            navController=navController,
                            growerRepository = growerRepository)

                    }

                }
            }



        }

    }


@Composable
fun GrowerItem(
    name: String,
    gnumber: String,
    idnumber: String,
    phone: String,
    bushes: String,
    garea: String,
    id: String,
    navController: NavHostController,
    growerRepository: GrowerRepository
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Name: $name",fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(text = "Grower Number: $gnumber")
            Text(text = "ID Number: $idnumber")
            Text(text = "Phone: $phone")
            Text(text = "Bushes: $bushes")
            Text(text = "Area(Acres): $garea")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(colors = ButtonDefaults.buttonColors(Color.Yellow),
                    onClick = {
                        navController.navigate(ROUTE_UPDATE_GROWER + "/$id")
                    }

                ) {
                    Text(text = "Update",color = Color.Black)
                }

                Button(colors = ButtonDefaults.buttonColors(Color.Yellow),
                    onClick = {
                        growerRepository.deleteGrower(id)
                    }
                ) {
                    Text(text = "Delete",color = Color.Black)
                }
            }
        }
    }
}






//@Composable
//fun GrowerItem(
//    name: String,
//    gnumber: String,
//    idnumber: String,
//    phone: String,
//    bushes: String,
//    garea: String,
//    id: String,
//    navController: NavHostController,
//    growerRepository: GrowerRepository
//) {

//
//   Table(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp) // Add padding as needed
//    ) {
//        tableRow {
//            tableCell {
//                Text(text = "Name")
//            }
//            tableCell {
//                Text(text = "G-Number")
//            }
//            tableCell {
//                Text(text = "ID Number")
//            }
//            tableCell {
//                Text(text = "Phone")
//            }
//            tableCell {
//                Text(text = "Bushes")
//            }
//            tableCell {
//                Text(text = "G Area")
//            }
//            tableCell {
//                // Empty cell for spacing
//            }
//            tableCell {
//                // Empty cell for spacing
//            }
//        }
//
//        tableRow {
//            tableCell {
//                Text(text = name)
//            }
//            tableCell {
//                Text(text = gnumber)
//            }
//            tableCell {
//                Text(text = idnumber)
//            }
//            tableCell {
//                Text(text = phone)
//            }
//            tableCell {
//                Text(text = bushes)
//            }
//            tableCell {
//                Text(text = garea)
//            }
//            tableCell {
//                Button(
//                    onClick = {
//                        navController.navigate(ROUTE_UPDATE_GROWER + "/$id")
//                    }
//                ) {
//                    Text(text = "Update")
//                }
//            }
//            tableCell {
//                Button(
//                    onClick = {
//                        growerRepository.deleteGrower(id)
//                    }
//                ) {
//                    Text(text = "Delete")
//                }
//            }
//        }
//    }
//}



//@Composable
//fun GrowerItem(
//    name: String,
//    gnumber: String,
//    idnumber: String,
//    phone: String,
//    bushes: String,
//    garea: String,
//    id: String,
//    navController: NavHostController,
//    growerRepository: GrowerRepository
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//    ) {
//        // Displaying data in a tabular form
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(4.dp)
//        ) {
//            Text(text = "Name:")
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(text = name)
//        }
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(4.dp)
//        ) {
//            Text(text = "Grower Number:")
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(text = gnumber)
//        }
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(4.dp)
//        ) {
//            Text(text = "ID Number:")
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(text = idnumber)
//        }
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(4.dp)
//        ) {
//            Text(text = "Phone:")
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(text = phone)
//        }
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(4.dp)
//        ) {
//            Text(text = "Bushes:")
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(text = bushes)
//        }
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(4.dp)
//        ) {
//            Text(text = "Growing Area:")
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(text = garea)
//        }
//
//        // Buttons for update and delete
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 8.dp)
//        ) {
//            Button(
//                onClick = {
//                    navController.navigate(ROUTE_UPDATE_GROWER + "/$id")
//                },
//                modifier = Modifier.padding(end = 8.dp)
//            ) {
//                Text(text = "Update")
//            }
//
//            Button(
//                onClick = {
//                    growerRepository.deleteGrower(id)
//                }
//            ) {
//                Text(text = "Delete")
//            }
//        }
//    }
//}



//@Composable
//fun GrowerItem(name: String, gnumber: String, idnumber: String, phone: String, bushes: String, garea: String,id:String, navController: NavHostController,
//                growerRepository:GrowerRepository) {
//
//    Column(modifier = Modifier.fillMaxWidth()) {
//        Text(text = name)
//        Text(text = gnumber)
//        Text(text = idnumber)
//        Text(text = phone)
//        Text(text = bushes)
//        Text(text = garea)
//
//        Button(onClick = {
//            navController.navigate(ROUTE_UPDATE_GROWER+"/$id")
//        }) {
//            Text(text = "Update")
//
//        }
//        Button(onClick = {
//            growerRepository.deleteGrower(id)
//        }) {
//            Text(text = "Delete")
//
//        }
//
//    }
//}