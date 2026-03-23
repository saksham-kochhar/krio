package com.example.krio

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.krio.SCREEN.Authscreen
import com.example.krio.SCREEN.otpscreen
import com.example.krio.SCREEN.routes
import com.example.krio.SCREEN.Homepage
import com.example.krio.SCREEN.signup

@Composable
fun appnavigation(modifier: Modifier = Modifier, authviewmodel: Authviewmodel){
    val navcontroller = rememberNavController()

    NavHost(navcontroller, startDestination = routes.authscreen, modifier = Modifier) {
        composable(routes.authscreen) {
            Authscreen(Modifier,navcontroller)
        }
        composable(routes.otpscreen + "/{phonenumber}") {
            val phonenumber = it.arguments?.getString("phonenumber")
            otpscreen(navcontroller,phonenumber,modifier,authviewmodel)
        }
        composable(routes.homepage){
            Homepage(navcontroller,modifier)
        }
        composable(routes.Signup) {
            signup(navcontroller)
        }
    }
}