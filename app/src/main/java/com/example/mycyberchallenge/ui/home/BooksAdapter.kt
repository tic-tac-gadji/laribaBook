package com.example.mycyberchallenge.ui.home


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycyberchallenge.models.Book
import com.example.mycyberchallenge.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdapter(
    val items: ArrayList<Book>
) : RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount() = items.size

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_book, parent, false)
        )

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(type: Book) {
            itemView.bookPrice.text = type.price
            itemView.bookAvailable.visibility = if (type.isAvailable) View.GONE else View.VISIBLE
            Picasso
                .get()
                .load(type.imageUrl)
                .into(itemView.bookImage)
        }
    }
}



