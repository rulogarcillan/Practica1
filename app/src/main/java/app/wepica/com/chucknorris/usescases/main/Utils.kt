package app.wepica.com.chucknorris.usescases.main

import android.app.Activity
import android.content.Context
import android.support.v7.app.AlertDialog
import app.wepica.com.chucknorris.R
import app.wepica.com.chucknorris.usescases.main.favorites.FavoritesFragment

class Utils {

    companion object {
        fun dialog(mActivity: Any?){
            val builder = AlertDialog.Builder(mActivity as Activity)
            val dialog: AlertDialog = builder.create()
            dialog.setView(mActivity.layoutInflater.inflate(R.layout.view_loading, null))
            dialog.show()
        }
    }

}
