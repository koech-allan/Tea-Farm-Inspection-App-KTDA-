package com.example.digitalfarminspectionapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.digitalfarminspectionapp.ui.theme.pages.growers.AddGrowerScreen
import com.example.digitalfarminspectionapp.ui.theme.pages.growers.GrowerdetailsScreen
import com.example.digitalfarminspectionapp.ui.theme.pages.growers.UpdateGrowerScreen
import com.example.digitalfarminspectionapp.ui.theme.pages.home.HomeScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavHostController = rememberNavController(),
               startDestination: String = ROUTE_HOME){

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination){
//        composable(ROUTE_HOME){
//            LoginScreen(navController)
//        }
//        composable(ROUTE_SIGNUP){
//            SignupScreen(navController)
//        }
        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_ADD_GROWER){
            AddGrowerScreen(navController)
        }
        composable(ROUTE_GROWER_DETAILS){
            GrowerdetailsScreen(navController)
        }
        composable(ROUTE_UPDATE_GROWER+"/{id}"){ passedData->
            UpdateGrowerScreen(navController,passedData.arguments?.getString("id")!!)
        }
    }

}