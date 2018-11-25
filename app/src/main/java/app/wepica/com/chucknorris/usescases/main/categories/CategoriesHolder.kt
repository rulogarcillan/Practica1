package app.wepica.com.chucknorris.usescases.main.categories

import android.support.v7.widget.RecyclerView
import android.view.View
import app.wepica.com.chucknorris.usescases.main.utils.GlobalConstant
import app.wepica.com.chucknorris.usescases.main.utils.loadFromUrl
import kotlinx.android.synthetic.main.item_categories.view.*

class CategoriesHolder(var rootView: View) : RecyclerView.ViewHolder(rootView) {


    fun bind(nameCategory: String, listener: CategoriesActions) {

        rootView.imageCategories.loadFromUrl(GlobalConstant.PATH_IMAGE + nameCategory)

        rootView.nameCategory.text = nameCategory

        rootView.setOnClickListener { listener.onClick(nameCategory) }
    }
}