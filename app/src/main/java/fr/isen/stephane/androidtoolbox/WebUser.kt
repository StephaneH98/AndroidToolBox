package fr.isen.stephane.androidtoolbox

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class WebUser(
    var nameWeb: String = "",
    var address: String = "",
    var email: String = "",
    var image: String = ""
):Parcelable
