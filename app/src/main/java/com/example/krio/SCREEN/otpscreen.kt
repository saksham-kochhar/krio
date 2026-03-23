package com.example.krio.SCREEN

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.krio.Authviewmodel
import com.example.krio.ui.theme.poppins
import com.example.krio.ui.theme.poppinsmedium


@Composable
fun otpinput(otp : String, onotpchange:(String) -> Unit,
             modifier: Modifier) {
    BasicTextField(value =  otp ,
        onValueChange = { if (it.length <= 6)
            onotpchange(it)} , keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)  )
    { Box(modifier = Modifier.fillMaxWidth().background(color = Color(0xFFF6F6F6)), contentAlignment = Alignment.Center){
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            repeat(6){ index ->
                val number = when {
                    index >= otp.length -> ""
                    else -> otp[index]
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.background(color = Color.White)
                        .border(width = 1.dp, color = Color.White ,
                            shape = RoundedCornerShape(8.dp)).padding(top = 6.dp, bottom = 6.dp) ) {


                    Text(text = number.toString() , style = TextStyle (
                        fontSize = 22.sp,
                        fontStyle = FontStyle.Normal,
                        fontFamily = poppinsmedium,
                        fontWeight = FontWeight.Bold
                    ) )

                    Box(modifier = Modifier.width(40.dp)
                        .height(2.dp)
                        .background(color = Color(0xFF3A3A3A))) {  }
                }

            }

        }
    } }
}
@Composable
fun otpscreen(navcontroller: NavHostController
              , phonenumber: String? , modifier : Modifier, viewmodel : Authviewmodel) {
    var otp by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(top = 64.dp, start = 6.dp,
        end = 6.dp, bottom = 10.dp , )) {

        IconButton(onClick = { navcontroller.navigate(routes.authscreen) }) {
            Icon( imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
        }
        Column(modifier =  Modifier.padding(start = 13.dp, end = 13.dp)) {
        Text(text = "OTP \nVerification", style = TextStyle(
            fontSize = 35.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = poppins,
            fontStyle = FontStyle.Italic
        ))
        Spacer(modifier = Modifier.height(13.dp))
        Text(text = "OTP has been sent to ", style = TextStyle(
            fontSize = 22.sp ,
            fontStyle = FontStyle.Italic,
            fontFamily = poppinsmedium,
            fontWeight = FontWeight.Medium
        ) , color = Color.DarkGray)
        Text(text = "+91 ${phonenumber}",
            style = TextStyle (
            fontSize = 22.sp ,
            fontStyle = FontStyle.Normal,
            fontFamily = poppinsmedium,
            fontWeight = FontWeight.Bold
        ))
            Spacer(modifier = Modifier.height(22.dp))

        otpinput(otp , onotpchange =  {otp = it} , modifier = Modifier)
            Spacer(modifier = Modifier.height(26.dp))
        Button(onClick = {navcontroller.navigate(routes.homepage)} , modifier =
            Modifier.align(alignment = Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 4.dp) , enabled = otp.length == 6)
        { Text(text = "Continue") }
    }
}


}