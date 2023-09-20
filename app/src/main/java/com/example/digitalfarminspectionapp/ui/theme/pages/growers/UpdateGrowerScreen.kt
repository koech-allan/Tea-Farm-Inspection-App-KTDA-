package com.example.digitalfarminspectionapp.ui.theme.pages.growers

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.digitalfarminspectionapp.data.GrowerRepository
import com.example.digitalfarminspectionapp.models.Grower
import com.example.digitalfarminspectionapp.ui.theme.DigitalFarmInspectionAppTheme
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateGrowerScreen(navController: NavHostController,id:String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context = LocalContext.current
        var name by remember { mutableStateOf("") }
        var gnumber by remember { mutableStateOf("") }
        var idnumber by remember { mutableStateOf("") }
        var phone by remember { mutableStateOf("") }
        var bushes by remember { mutableStateOf("") }
        var garea by remember { mutableStateOf("") }

        var currentDataRef = FirebaseDatabase.getInstance().getReference().child("Growers/$id")

        currentDataRef.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var grower = snapshot.getValue(Grower::class.java)
                name = grower!!.name
                gnumber = grower!!.gnumber
                idnumber = grower!!.idnumber
                phone = grower!!.phone
                bushes = grower!!.bushes
                garea = grower!!.garea
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })



        Text(
            text = "Update Grower Information",
            fontSize = 30.sp,
            color = Color.Green,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var growerName by remember { mutableStateOf(TextFieldValue("")) }
        var growerNumber by remember { mutableStateOf(TextFieldValue("")) }
        var growerId by remember { mutableStateOf(TextFieldValue("")) }
        var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
        var numberofBushes by remember { mutableStateOf(TextFieldValue("")) }
        var area by remember { mutableStateOf(TextFieldValue("")) }



        OutlinedTextField(
            value = growerName,
            label = { Text(text = "Grower Name...") },
            onValueChange = {
                growerName = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = growerNumber,
            label = { Text(text = "Grower Number...") },
            onValueChange = {
                growerNumber = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = growerId,
            label = { Text(text = "ID Number...") },
            onValueChange = {
                growerId = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = phoneNumber,
            label = { Text(text = "Phone Number...") },
            onValueChange = {
                phoneNumber = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = numberofBushes,
            label = { Text(text = "Number of Bushes...") },
            onValueChange = {
                numberofBushes = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = area,
            label = { Text(text = "Land size...") },
            onValueChange = {
                area = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
//            Write the update logic here
            var growerRepository = GrowerRepository(navController, context)
            growerRepository.updateGrower(growerName.text.trim(), growerNumber.text.trim(),
                growerId.text.trim(),phoneNumber.text.trim(),numberofBushes.text.trim(),area.text.trim(),id)

        }, colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
            Text(text = "Update")
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun UpdateGrowerScreenPreview() {
    DigitalFarmInspectionAppTheme {
        UpdateGrowerScreen(rememberNavController(),id="")

    }
}