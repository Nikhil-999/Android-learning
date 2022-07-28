package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+[.]+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        val userName = intent.getStringExtra("userName_key")
        var welMessage = intent.getStringExtra("myMessage")
        welMessage = welMessage.toString().uppercase()

        val textData = findViewById<TextView>(R.id.textData)
        textData.text = "Welcome $userName !!"

        val myMessage = findViewById<TextView>(R.id.textMessage)
        myMessage.text = "Looks like we have great $welMessage opportunities for you\n\nSign up with us below."

//        val Submit = findViewById<Button>(R.id.btn_signup)

    }

    fun signUpClicked(view: View){
        val fullName = findViewById<EditText>(R.id.userName)
        val phoneNumber = findViewById<EditText>(R.id.userNumber)
        val userAddress = findViewById<EditText>(R.id.userAddress)
        val pincode = findViewById<EditText>(R.id.userPincode)
        val email = findViewById<EditText>(R.id.userEmail)
        val password = findViewById<EditText>(R.id.userPassword)
        val confirmPassword = findViewById<EditText>(R.id.userConfirmPassword)
        var check = true;



        if(fullName.text.toString() == "" || phoneNumber.text.toString() == "" || userAddress.text.toString() == "" || pincode.text.toString() == "" || email.text.toString() == "" || password.text.toString() == "" || confirmPassword.text.toString() == ""){
            Toast.makeText(this, "Element or more than one element shouldn't be EMPTY", Toast.LENGTH_LONG).show()
            return;
        }
        else{
            if(phoneNumber.text.toString().length != 10 ){
                Toast.makeText(this, "Number should be of 10 Digits", Toast.LENGTH_SHORT).show()
                check = false;
            }
            if(userAddress.text.toString().length < 3 || userAddress.text.toString().length > 20 ){
                Toast.makeText(this, "Address should be more than 2 and less than 20 chars", Toast.LENGTH_SHORT).show()
                check = false;
            }
            if(pincode.text.toString().length != 6 ){
                Snackbar.make(pincode , "Invalid Pincode buddy" , Snackbar.LENGTH_LONG).setAction("Retry" , View.OnClickListener(){
                    Toast.makeText(this,"You should Enter your pincode again",Toast.LENGTH_LONG).show();
                }).show()
                check = false;
            }
            val demo = confirmPassword.text.toString()
            if(!password.text.toString().equals(demo) ){
                Toast.makeText(this, "Password doesn't matched", Toast.LENGTH_SHORT).show()
                check = false;
            }
            if(!email.text.toString().trim().matches(emailPattern.toRegex())){
                Toast.makeText(this, "Invalid Email Format", Toast.LENGTH_SHORT).show()
                check = false;
            }
        }

        if(check){
            Toast.makeText(this, "Succesfully SIGNED UP", Toast.LENGTH_SHORT).show()
        }

    }
}