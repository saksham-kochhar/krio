package com.example.krio.SCREEN

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.krio.ui.theme.Authgrey
import com.example.krio.ui.theme.poppins
import com.example.krio.ui.theme.poppinsmedium
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.auth

@Composable
fun Authscreen (modifier: Modifier = Modifier.fillMaxSize(), navcontroller: NavHostController){

    var phonenumber by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().background(color = Authgrey).padding(32.dp)) {
        Spacer(modifier = Modifier.height(55.dp))
        Text(text = "Kiro", style = TextStyle(
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = poppins)
        , color = Color(0xFF1A1A1A) )

        Text(text = "Freshness delivered from your nukkad.",
            modifier = Modifier.padding(top = 1.dp),
            style = TextStyle(
                fontSize = 22.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = poppinsmedium,
                fontStyle = FontStyle.Italic
            ),
            color = Color(0xFF6F6F6F)
            )


        OutlinedTextField(value = phonenumber,
            onValueChange = {phonenumber = it.filter { it.isDigit()}.take(10)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,

            modifier = Modifier.fillMaxWidth().padding(top = 60.dp),
            shape = RoundedCornerShape(12.dp),
            label = {Text(text = "Phone Number")},

            leadingIcon = { Text(text = "+91",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = poppinsmedium,
                    fontStyle = FontStyle.Normal
                ), color = Color.DarkGray)
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick ={
            navcontroller.navigate(routes.otpscreen + "/${phonenumber}")}
            ,enabled = phonenumber.length == 10,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
            Text(text = "Continue")
        }
    }

    }

