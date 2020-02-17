package fr.isen.stephane.androidtoolbox

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_permissions.view.*

class RecyclerViewAdapter(private val items : ArrayList<User>, val context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.activity_permissions, parent, false)
        return ViewHolder(items,view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.loadInfo(position)
    }

    class ViewHolder (private val contactList: ArrayList<User>, view:View): RecyclerView.ViewHolder(view){
        val id: TextView = view.idDisplayIdCell
        val name: TextView = view.idDisplayNameCell
        private val phone: TextView = view.idDisplayPhoneCell


        fun loadInfo(index:Int){
            id.text = contactList[index].id
            name.text = contactList[index].name
            phone.text = contactList[index].phoneNumber
        }

    }


}

