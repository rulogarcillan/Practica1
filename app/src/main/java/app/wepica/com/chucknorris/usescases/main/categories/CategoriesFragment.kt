package app.wepica.com.chucknorris.usescases.main.categories

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.wepica.com.chucknorris.R
import app.wepica.com.chucknorris.usescases.main.Utils
import kotlinx.android.synthetic.main.fragment_categories.view.*

class CategoriesFragment : Fragment() {

    companion object {
        fun newInstance(): CategoriesFragment = CategoriesFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_categories, container, false)
        view.message.text = "Categories"
        return view
    }
}