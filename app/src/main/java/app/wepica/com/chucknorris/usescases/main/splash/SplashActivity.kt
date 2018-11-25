package app.wepica.com.chucknorris.usescases.main.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import app.wepica.com.chucknorris.R
import app.wepica.com.chucknorris.usescases.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashScreen()
    }

    private fun splashScreen() {
        val time = 3000L
        Handler().postDelayed(
            {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            },
            time
        )
    }

}
