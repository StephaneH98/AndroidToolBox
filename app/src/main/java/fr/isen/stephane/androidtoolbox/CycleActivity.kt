package fr.isen.stephane.androidtoolbox

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.isen.stephane.androidtoolbox.fragment.CycleFragment
import fr.isen.stephane.androidtoolbox.fragment.CycleFragment2
import kotlinx.android.synthetic.main.activity_cycle.*

class CycleActivity : AppCompatActivity(), CycleFragment.OnFragmentInteractionListener, CycleFragment2.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var isActivityRunning = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cycle)
        showLog("Cycle de vie activité : OnCreate - ")


        button_frag1.setOnClickListener{
            val fragment1 = CycleFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment, fragment1)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        button_frag2.setOnClickListener{
            val fragment2 = CycleFragment2()
            val transaction2 = supportFragmentManager.beginTransaction()
            transaction2.replace(R.id.fragment, fragment2)
            transaction2.addToBackStack(null)
            transaction2.commit()
        }

        home_button.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        showLog("Cycle de vie activité : onStart - \n")
    }

    override fun onResume() {
        super.onResume()
        showLog("Cycle de vie activité : onResume - \n")
    }

    override fun onPause() {
        super.onPause()
        isActivityRunning = false
        showLog("Cycle de vie activité : onPause - \n")
    }

    override fun onStop() {
        super.onStop()
        showLog("Cycle de vie activité : onStop - ")
    }

    override fun onRestart() {
        super.onRestart()
        showLog("Cycle de vie activité : onRestart - \n")
    }

    override fun onDestroy() {
        super.onDestroy()
        showLog("Cycle de vie activité : onDestroy - \n")
        Toast.makeText(this, "Activité détruite", Toast.LENGTH_LONG).show()
    }

    private fun showLog(msg: String){
        if(isActivityRunning){
            val newMessage = message.text.toString() + msg
            message.text = newMessage
        }
        else {
            Log.i("LifeStyleActivity", msg)
        }
    }
}
