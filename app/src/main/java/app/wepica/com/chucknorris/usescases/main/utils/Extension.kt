package app.wepica.com.chucknorris.usescases.main.utils

import android.widget.ImageView

fun ImageView.loadFromUrl(url: String?) {
    GlideApp.with(context).load(url).into(this)
}