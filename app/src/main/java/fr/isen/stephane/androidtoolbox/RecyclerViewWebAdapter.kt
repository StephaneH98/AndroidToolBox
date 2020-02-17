package fr.isen.stephane.androidtoolbox


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.web_services.view.*

class RecyclerViewAdapterWeb(private val users :RandomUser, val context: Context) : RecyclerView.Adapter<RecyclerViewAdapterWeb.ViewHolderWeb>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderWeb {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.web_services, parent, false)
        return ViewHolderWeb(users,view,context)
    }

    override fun getItemCount(): Int {
        return users.results.size
    }

    override fun onBindViewHolder(holder: ViewHolderWeb, position: Int) {
        holder.loadInfo(position)
    }

    class ViewHolderWeb (private val webUsers: RandomUser, view:View, val context: Context): RecyclerView.ViewHolder(view){
        private val name: TextView = view.nameWeb
        private val image: ImageView = view.pictureWeb
        private val address: TextView = view.addressWeb
        private val email: TextView = view.emailWeb


        fun loadInfo(index: Int){
            val nameWeb = webUsers.results[index].name.first + " " + webUsers.results[index].name.last
            val addressWeb = webUsers.results[index].location.street.number.toString() + " " + webUsers.results[index].location.street.name + " " +webUsers.results[index].location.city
            Glide.with(context)
                .load(webUsers.results[index].picture.large)
                .apply(RequestOptions.circleCropTransform())
                .into(image)

            name.text = nameWeb
            email.text =webUsers.results[index].email
            address.text = addressWeb

        }

    }




}

