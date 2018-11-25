package app.wepica.com.chucknorris.usescases.main.favorites

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import app.wepica.com.chucknorris.R
import app.wepica.com.chucknorris.usescases.main.jokes.JokesHolder
import app.wepica.com.chucknorris.usescases.main.jokes.models.Joke

class FavoritesViewAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var jokes: ArrayList<Joke>

    constructor(jokes: ArrayList<Joke>) : this() {
        this.jokes = jokes
    }

    override fun getItemCount() = jokes.size

    override fun onCreateViewHolder(rootView: ViewGroup, itemViewType: Int): RecyclerView.ViewHolder =
        FavoritesHolder(LayoutInflater.from(rootView.context).inflate(R.layout.item_joke, rootView, false), this)

    override fun onBindViewHolder(rootView: RecyclerView.ViewHolder, position: Int) {
        (rootView as FavoritesHolder).bind(jokes[position], position)
    }
}