package app.wepica.com.chucknorris.usescases.main.jokes.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Joke(
    var category: ArrayList<String>?,
    var icon_url: String?,
    var id: String?,
    var url: String?,
    var value: String = ""
) : Parcelable