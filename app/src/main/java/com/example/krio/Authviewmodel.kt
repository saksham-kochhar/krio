package com.example.krio

import android.app.Activity
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.krio.SCREEN.routes
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider

class Authviewmodel : ViewModel() {

    private val auth : FirebaseAuth = FirebaseAuth.getInstance()
    private val _authstate = MutableLiveData<Authstate>()
    var phone : String = ""

    private val _verficiationid = MutableLiveData<String?>()
    val verfificationid : LiveData<String?> = _verficiationid
    val authstate : LiveData<Authstate> = _authstate
    fun checkauthstatus(){
        if(auth.currentUser == null){
            _authstate.value = Authstate.Unauthenticated
        }else {
            _authstate.value = Authstate.Authenticated
        }
    }
    fun login(phonenumber : String , activity: Activity , navController: NavHostController){
        _authstate.value = Authstate.loading
        val options = PhoneAuthOptions.newBuilder(auth)
        .setPhoneNumber(phonenumber)
        .setTimeout(60L, java.util.concurrent.TimeUnit.SECONDS )
        .setActivity(activity)
        .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                auth.signInWithCredential(credential).addOnCompleteListener {
                    if (it.isSuccessful){
                        _authstate.value = Authstate.Authenticated
                        navController.navigate(routes.homepage){
                            popUpTo(0) {inclusive = true}
                        }
                    }
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                _authstate.value = Authstate.error(p0.message ?: "Something Went Wrong!!!")
                Toast.makeText(activity , "Wrong Credentials", Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(VerificationID: String, Token : PhoneAuthProvider.ForceResendingToken) {
                Toast.makeText(activity , "OTP Sent Successfully", Toast.LENGTH_SHORT).show()
                _verficiationid.value = VerificationID
                navController.navigate(routes.otpscreen)
            }

        } ).build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }


}
sealed class Authstate {
    object Authenticated : Authstate()
    object Unauthenticated : Authstate()
    object loading : Authstate()
    data class error (val message : String) : Authstate()
}