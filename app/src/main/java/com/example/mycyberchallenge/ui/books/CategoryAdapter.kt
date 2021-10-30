package com.example.mycyberchallenge.ui.books


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycyberchallenge.R
import com.example.mycyberchallenge.models.Category
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(
    val items: ArrayList<Category>
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount() = items.size

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_category, parent, false)
        )

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(type: Category) {
            itemView.categoryTitle.text = type.name
            Picasso
                .get()
                .load(type.imageUrl)
                .into(itemView.categoryImage)
        }
    }
}



