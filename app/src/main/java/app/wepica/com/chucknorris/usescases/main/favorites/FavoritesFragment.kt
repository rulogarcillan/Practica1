package app.wepica.com.chucknorris.usescases.main.favorites

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.wepica.com.chucknorris.R
import app.wepica.com.chucknorris.usescases.main.Utils
import kotlinx.android.synthetic.main.fragment_favorites.view.*
import android.app.Activity



class FavoritesFragment : Fragment() {

    companion object {
        fun newInstance(): FavoritesFragment = FavoritesFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Utils.dialog(activity)
        var view = inflater.inflate(R.layout.fragment_favorites, container, false)
        view.message.text = "favorites"
        return view
    }
}