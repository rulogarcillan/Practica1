package app.wepica.com.chucknorris.usescases.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import app.wepica.com.chucknorris.R
import app.wepica.com.chucknorris.usescases.main.categories.CategoriesFragment
import app.wepica.com.chucknorris.usescases.main.favorites.FavoritesFragment
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.R.attr.orientation
import android.content.res.Configuration


class MainActivity : GlobalActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addCategoriesFragment()
        //call to navigation menu
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_categories -> {
                addCategoriesFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorites -> {
                addFavoritesFragment()
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    private fun addCategoriesFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, CategoriesFragment.newInstance())
            .commit()
    }

    private fun addFavoritesFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FavoritesFragment.newInstance())
            .commit()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (navigation.selectedItemId == R.id.navigation_categories) {
            addCategoriesFragment()
        }

    }
}
