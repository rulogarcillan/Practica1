package app.wepica.com.chucknorris.usescases.main.jokes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import app.wepica.com.chucknorris.R
import app.wepica.com.chucknorris.usescases.main.jokes.models.Joke

class JokesViewAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var jokes: ArrayList<Joke>

    constructor(jokes: ArrayList<Joke>) : this() {
        this.jokes = jokes
    }

    override fun getItemCount() = jokes.size


    override fun onCreateViewHolder(rootView: ViewGroup, itemViewType: Int): RecyclerView.ViewHolder =
        JokesHolder(LayoutInflater.from(rootView.context).inflate(R.layout.item_joke, rootView, false))

    override fun onBindViewHolder(rootView: RecyclerView.ViewHolder, position: Int) {
        (rootView as JokesHolder).bind(jokes[position])
    }
}