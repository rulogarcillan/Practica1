package app.wepica.com.chucknorris.usescases.main.jokes

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import app.wepica.com.chucknorris.R
import app.wepica.com.chucknorris.usescases.main.GlobalActivity
import app.wepica.com.chucknorris.usescases.main.jokes.models.Joke
import app.wepica.com.chucknorris.usescases.main.utils.GlobalConstant
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_jokes.*


class JokesActivity : GlobalActivity() {


    private lateinit var category: String
    private var jokes: ArrayList<Joke> = arrayListOf()
    private lateinit var viewAdapter: JokesViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokes)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        readIntent()
        changeTextButton()
        addAdapter()
        getJoke()
        moreJokes.setOnClickListener { getJoke() }
    }

    private fun changeTextButton() {
        moreJokes.text = String.format(getString(R.string.title_more_jokes), category)
    }

    private fun readIntent() {
        category = intent.getStringExtra(GlobalConstant.CATEGORY)
    }


    private fun addAdapter() {
        viewAdapter = JokesViewAdapter(jokes)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = viewAdapter
    }

    private fun getJoke() {
        showProgressDialog()
        Thread {
            val result = java.net.URL(GlobalConstant.URL_JOKES + category).readText()
            this.runOnUiThread {
                cancelProgressDialog()
                jokes.add(Gson().fromJson(result, Joke::class.java))
                viewAdapter.notifyDataSetChanged()
            }
        }.start()
    }





}
