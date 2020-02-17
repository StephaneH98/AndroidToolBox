package fr.isen.stephane.androidtoolbox

import android.app.AlertDialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_formulaire.*
import java.util.*
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit

class FormulaireActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire)

        val gson = Gson()
        val user: Users = Users()
        var json: String = gson.toJson(user)
        var selectDate = Calendar.getInstance()

        val date: TextView = findViewById(R.id.dateTxt)
        date.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())

        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth -> //init the calendar
            selectDate.set(Calendar.YEAR, year)
            selectDate.set(Calendar.MONTH, monthOfYear)
            selectDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            date.text = SimpleDateFormat("dd.MM.yyyy", Locale.FRANCE).format(selectDate.time)
        }

        calendarBtn.setOnClickListener{//show the calender
            DatePickerDialog(this, dateSetListener,
                selectDate.get(Calendar.YEAR),
                selectDate.get(Calendar.MONTH),
                selectDate.get(Calendar.DAY_OF_MONTH)).show()
        }

        valider.setOnClickListener {
            val dataBase = gson.fromJson(json, Users::class.java)//open the data base
            var alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)//init alert

            user.name = nameField.text.toString()
            user.surname = surnameField.text.toString()
            user.birthday = dateTxt.text.toString()


            json = gson.toJson(user)

            if (dataBase.name == "" || dataBase.surname == "" || dataBase.birthday == "" ){//check if the data are empty or not
                alertDialogBuilder//build error alert
                    .setTitle("Error")
                    .setMessage("Veuillez saisir tout les champs")
                val alertDialog: AlertDialog = alertDialogBuilder.create()
                alertDialog.show()//show alert
            }
            else{
                val toast = Toast.makeText(this, "Informations enregistrées", Toast.LENGTH_LONG).show()
            }

        }

        infoBtn.setOnClickListener{
            val dataBase = gson.fromJson(json, Users::class.java)//open the data base
            var alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)//init alert
            val birthday = SimpleDateFormat("dd.MM.yyyy").parse(user.birthday).time //get user's birthday
            val today  = Calendar.getInstance().timeInMillis// get the date of today in mil. sec
            val difference = today - birthday // delta between today and the birthday
            val conv = TimeUnit.MILLISECONDS.toDays(difference) // conversion mil. sec to day
            val age = conv / 365 //age computing

            if (dataBase.name == "" || dataBase.surname == "" || dataBase.birthday == "" ){//check if the data are empty or not
                alertDialogBuilder//build error alert
                    .setTitle("Error")
                    .setMessage("Veuillez saisir tout les champs")
            }
            else{
                alertDialogBuilder//build information alert
                    .setTitle("Informations")
                    .setMessage("Nom : " + dataBase.name + "\nPrenom : " + dataBase.surname + "\nDate de naissance : " + dataBase.birthday + "\nAge : " + age)
            }

            val alertDialog: AlertDialog = alertDialogBuilder.create()
            alertDialog.show()//show alert
        }
    }


}
