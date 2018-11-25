package app.wepica.com.chucknorris.usescases.main.favorites

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.wepica.com.chucknorris.R
import app.wepica.com.chucknorris.usescases.main.jokes.models.Joke
import app.wepica.com.chucknorris.usescases.main.utils.GlobalConstant
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_favorites.view.*


class FavoritesFragment : Fragment() {

    private var jokes: ArrayList<Joke> = arrayListOf()
    lateinit var viewAdapter: FavoritesViewAdapter
    lateinit var preferences: SharedPreferences

    companion object {
        fun newInstance(): FavoritesFragment = FavoritesFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)
        preferences = (requireActivity()).getSharedPreferences(GlobalConstant.FAVORITES, Context.MODE_PRIVATE)
        getJokesSaved()
        addAdapter(view)
        return view
    }

    private fun addAdapter(rootView : View) {
        viewAdapter = FavoritesViewAdapter(jokes)
        rootView.myRecyclerView.layoutManager = LinearLayoutManager(context)
        rootView.myRecyclerView.adapter = viewAdapter
    }

    private fun getJokesSaved() {
        val jsonJokes = preferences.getStringSet(GlobalConstant.JOKES, null)
        jsonJokes?.forEach { jokes.add(Gson().fromJson(it, Joke::class.java)) }
    }
}