package app.wepica.com.chucknorris.usescases.main

import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import app.wepica.com.chucknorris.R

abstract class GlobalActivity : AppCompatActivity() {

    private lateinit var alertDialog: AlertDialog

    private fun createDialog(): AlertDialog {
        val builder = AlertDialog.Builder(this)
        val dialog: AlertDialog = builder.create()
        dialog.setView(this.layoutInflater.inflate(R.layout.view_loading, null))
        dialog.setCancelable(false)
        return dialog
    }

    fun showProgressDialog() {
        if (!::alertDialog.isInitialized) {
            this.alertDialog = createDialog()
        }
        alertDialog.show()
    }

    fun cancelProgressDialog() {
        this.alertDialog.cancel()

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
