package fr.isen.stephane.androidtoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import android.preference.PreferenceManager.getDefaultSharedPreferences


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        valider.setOnClickListener { //click on "valider" buton
            //init variable
            val userName = userName.text.toString()
            val password = password.text.toString()

            val sharedPref = getDefaultSharedPreferences(this)
            val editor = sharedPref.edit()
            //save information
            editor.remove("loggedIn")
            editor.remove("userName")
            editor.remove("passwd")
            editor.apply()


            if (userName == "admin" && password == "123") { //check information
                Toast.makeText(this, userName, Toast.LENGTH_LONG).show()
                val intent = Intent(this, HomeActivity::class.java) //go to home page
                startActivity(intent)
            } else
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
        }

    }
}