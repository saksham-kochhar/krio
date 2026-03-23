package com.example.krio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class Authviewmodel : ViewModel() {

    init {
        checkauthstatus()
    }
    private val auth : FirebaseAuth = FirebaseAuth.getInstance()
    private val _authstate = MutableLiveData<Authstate>()
    val authstate : LiveData<Authstate> = _authstate
    fun checkauthstatus(){
        if(auth.currentUser == null){
            _authstate.value = Authstate.Unauthenticated
        }else {
            _authstate.value = Authstate.Authenticated
        }
    }
    fun login ()

}
sealed class Authstate {
    object Authenticated : Authstate()
    object Unauthenticated : Authstate()
    object loading : Authstate()
    data class error (val message : String) : Authstate()
}