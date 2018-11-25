package app.wepica.com.chucknorris.usescases.main.jokes

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import app.wepica.com.chucknorris.R
import app.wepica.com.chucknorris.usescases.main.jokes.models.Joke
import app.wepica.com.chucknorris.usescases.main.utils.GlobalConstant
import app.wepica.com.chucknorris.usescases.main.utils.loadFromUrl
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_joke.view.*

class JokesHolder(private var rootView: View) : RecyclerView.ViewHolder(rootView) {

    private lateinit var pref: SharedPreferences

    fun bind(joke: Joke) {
        pref = (rootView.context as Activity).getSharedPreferences(GlobalConstant.FAVORITES, Context.MODE_PRIVATE)

        rootView.imageJoke.loadFromUrl(joke.icon_url)
        rootView.textJoke.text = joke.value
        setIconFav(rootView, isFavJokes(joke))

        rootView.setOnClickListener {
            if (isFavJokes(joke)) {
                deleteJoke(joke)
                setIconFav(it, isFavJokes(joke))
                Toast.makeText(it.context, it.context.getString(R.string.title_nofav), Toast.LENGTH_SHORT).show()
            } else {
                saveJoke(joke)
                setIconFav(it, isFavJokes(joke))
                Toast.makeText(it.context, it.context.getString(R.string.title_fav), Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun isFavJokes(joke: Joke): Boolean {
        val jokes = pref.getStringSet(GlobalConstant.JOKES, null)
        val json = Gson().toJson(joke)
        if (jokes != null) {
            return jokes.contains(json)
        }
        return false
    }

    private fun setIconFav(rootView: View, fav: Boolean) {
        when (fav) {
            true -> rootView.iconFav.setImageDrawable(rootView.context.getDrawable(R.drawable.ic_favorite_black_24dp))
            false -> rootView.iconFav.setImageDrawable(rootView.context.getDrawable(R.drawable.ic_favorite_border_black_24dp))
        }
    }

    private fun getJokesSaved(): MutableSet<String>? = pref.getStringSet(GlobalConstant.JOKES, null)

    private fun saveJoke(joke: Joke) {
        val editor = pref.edit().clear()
        val jokes = getJokesSaved() ?: mutableSetOf()
        val json = Gson().toJson(joke)
        jokes.add(json)
        editor.putStringSet(GlobalConstant.JOKES, jokes)
        editor.apply()
    }

    private fun deleteJoke(joke: Joke) {
        val editor = pref.edit().clear()
        val jokes = getJokesSaved() ?: mutableSetOf()
        val json = Gson().toJson(joke)
        jokes.remove(json)
        val newJokes: MutableSet<String> = mutableSetOf()
        jokes.forEach { newJokes.add(it) }
        editor.putStringSet(GlobalConstant.JOKES, newJokes)
        editor.apply()
    }

}