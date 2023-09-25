package com.example.digitalfarminspectionapp.ui.theme.pages.growers

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.digitalfarminspectionapp.data.GrowerRepository
import com.example.digitalfarminspectionapp.ui.theme.DigitalFarmInspectionAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddGrowerScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
//            .paint(
            // Replace with your image id
//            painterResource(id = R.drawable.tea5),
//            contentScale = ContentScale.FillBounds) ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context = LocalContext.current
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "Grower Information",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))


        var growerName by remember { mutableStateOf(TextFieldValue("")) }
        var growerNumber by remember { mutableStateOf(TextFieldValue("")) }
        var growerId by remember { mutableStateOf(TextFieldValue("")) }
        var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
        var numberofBushes by remember { mutableStateOf(TextFieldValue("")) }
        var area by remember { mutableStateOf(TextFieldValue("")) }
        var successSave = remember { mutableStateOf(false) }
        if (successSave.value){
            growerName = TextFieldValue("")
            growerNumber = TextFieldValue("")
            growerId = TextFieldValue("")
            phoneNumber = TextFieldValue("")
            numberofBushes = TextFieldValue("")
            area = TextFieldValue("")
        }

        OutlinedTextField(
            value = growerName,
            label = { Text(text = "Enter Grower's Name**") },
            onValueChange = {
                growerName = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = growerNumber,
            label = { Text(text = "Enter Grower Number**") },
            onValueChange = {
                growerNumber = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = growerId,
            label = { Text(text = "Enter ID Number **") },
            onValueChange = {
                growerId = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = phoneNumber,
            label = { Text(text = "Enter Phone Number **") },
            onValueChange = {
                phoneNumber = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = numberofBushes,
            label = { Text(text = "Enter Number of Bushes**") },
            onValueChange = {
                numberofBushes = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = area,
            label = { Text(text = "Enter Land size(Acres)**") },
            onValueChange = {
                area = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )


        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
//            Write the save logic here
            var growerRepository = GrowerRepository(navController, context)
            growerRepository.saveGrower(growerName.text.trim(), growerNumber.text.trim(),
                growerId.text.trim(),phoneNumber.text.trim(),numberofBushes.text.trim(),area.text.trim(), successSave)

        }, colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
            Text(text = "Save")
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AddGrowerScreenPreview() {
    DigitalFarmInspectionAppTheme {
        AddGrowerScreen(rememberNavController())

        }
}
