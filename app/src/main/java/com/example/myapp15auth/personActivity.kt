package com.example.myapp15auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class personActivity : AppCompatActivity() {
    private lateinit var userInfoTextView: TextView
    private lateinit var changePasswordButton: Button
    private lateinit var logoutButton: Button

    private lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        auth = FirebaseAuth.getInstance()

        userInfoTextView = findViewById(R.id.userInfoTextView)
        changePasswordButton = findViewById(R.id.passwordChangeButton)
        logoutButton = findViewById(R.id.logOutButton)

        userInfoTextView.text = auth.currentUser?.uid

        logoutButton.setOnClickListener() {
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        changePasswordButton.setOnClickListener {
            startActivity(Intent(this, ChangePasswordActivity::class.java))


        }

    }
}

class PersonActivity {

}
