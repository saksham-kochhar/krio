package com.example.krio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.krio.ui.theme.KRIOTheme
import com.google.firebase.appcheck.FirebaseAppCheck
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewmodel = ViewModelProvider(this).get(Authviewmodel :: class.java)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KRIOTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    appnavigation(modifier = Modifier.padding(innerPadding),viewmodel)
                }
            }
        }
    }
}

