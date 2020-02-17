package fr.isen.stephane.androidtoolbox

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager.getDefaultSharedPreferences
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        imageConv.setOnClickListener {
            val intent = Intent(this, CycleActivity::class.java)
            startActivity(intent)
        }

        imageSD.setOnClickListener {
            val intent = Intent(this, FormulaireActivity::class.java)
            startActivity(intent)
        }

        imagePhone.setOnClickListener {
            val intent = Intent(this, PermissionActivity::class.java)
            startActivity(intent)
        }

        imageWeb.setOnClickListener {
            val intent = Intent(this, WebServicesActivity::class.java)
            startActivity(intent)
        }

        quitter.setOnClickListener {
            val intent = Intent (this, LoginActivity::class.java)
            val preferences = getDefaultSharedPreferences(this)
            val editor = preferences.edit()

            editor.clear()
            editor.apply()
            startActivity(intent)
        }
    }
}
