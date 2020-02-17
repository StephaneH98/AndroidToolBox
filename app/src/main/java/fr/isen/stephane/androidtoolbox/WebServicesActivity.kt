package fr.isen.stephane.androidtoolbox

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_web_services.*


class WebServicesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_services)
        jsonParse()

    }

    private fun jsonParse(){
        val mQueue = Volley.newRequestQueue(this)
        var webUsers:RandomUser
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, "https://randomuser.me/api/?inc=name%2Cpicture%2Clocation%2Cemail&noinfo=&nat=fr&format=pretty&results=10", null,
            Response.Listener { response ->
                val gson = Gson()
                webUsers = gson.fromJson(response.toString(),RandomUser::class.java)

                progressBar2.visibility = View.INVISIBLE
                recyclerViewWeb.layoutManager = LinearLayoutManager(this)
                recyclerViewWeb.adapter = RecyclerViewAdapterWeb(webUsers,this)
                recyclerViewWeb.visibility = View.VISIBLE

            },
            Response.ErrorListener {
                Log.d("TAG","There was an error")
            }
        )
        mQueue.add(jsonObjectRequest)
    }
}
