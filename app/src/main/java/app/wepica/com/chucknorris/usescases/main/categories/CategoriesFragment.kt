package app.wepica.com.chucknorris.usescases.main.categories

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.wepica.com.chucknorris.R
import app.wepica.com.chucknorris.usescases.main.MainActivity
import app.wepica.com.chucknorris.usescases.main.categories.models.Categories
import app.wepica.com.chucknorris.usescases.main.jokes.JokesActivity
import app.wepica.com.chucknorris.usescases.main.utils.GlobalConstant
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_categories.view.*
import java.net.URL

class CategoriesFragment : Fragment() {
    private var categories: Categories = Categories()
    private lateinit var viewAdapter: CategoriesViewAdapter


    companion object {
        fun newInstance(): CategoriesFragment = CategoriesFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_categories, container, false)
        getCategories()
        addAdapter(view)
        return view
    }

    private fun addAdapter(view: View) {
        viewAdapter = CategoriesViewAdapter(
            categories, object : CategoriesActions {
                override fun onClick(name: String) {
                    //Toast.makeText(context, name, Toast.LENGTH_SHORT).show()
                    startIntent(name)
                }
            }
        )

        view.myRecyclerView.layoutManager = GridLayoutManager(context, getNumberOfColumns())
        view.myRecyclerView.adapter = viewAdapter
    }

    private fun getNumberOfColumns(): Int =
        when (resources.configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> 6
            Configuration.ORIENTATION_PORTRAIT -> 3
            else -> {
                3
            }
        }


    private fun getCategories() {
        (activity as MainActivity).showProgressDialog()
        Thread {
            val result = URL(GlobalConstant.PATH_CATEGORIES).readText()
            activity?.runOnUiThread {
                (activity as MainActivity).cancelProgressDialog()
                categories = Gson().fromJson(result, Categories::class.java)
                viewAdapter.categories = categories
                viewAdapter.notifyItemInserted(categories.size)
            }
        }.start()
    }


    private fun startIntent(category: String) {
        val intent = Intent(context, JokesActivity::class.java)
        intent.putExtra(GlobalConstant.CATEGORY, category)
        startActivity(intent)
    }


}