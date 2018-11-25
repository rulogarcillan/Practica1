package app.wepica.com.chucknorris.usescases.main.categories

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import app.wepica.com.chucknorris.R
import app.wepica.com.chucknorris.usescases.main.categories.models.Categories

class CategoriesViewAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var categories: Categories
    lateinit var listener: CategoriesActions

    constructor(categories: Categories, listener: CategoriesActions) : this() {
        this.categories = categories
        this.listener = listener
    }

    override fun getItemCount() = categories.size


    override fun onCreateViewHolder(rootView: ViewGroup, itemViewType: Int): RecyclerView.ViewHolder =
        CategoriesHolder(LayoutInflater.from(rootView.context).inflate(R.layout.item_categories, rootView, false))

    override fun onBindViewHolder(rootView: RecyclerView.ViewHolder, position: Int) {
        (rootView as CategoriesHolder).bind(categories[position], listener)
    }
}