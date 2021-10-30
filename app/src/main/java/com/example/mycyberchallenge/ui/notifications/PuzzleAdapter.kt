package com.example.mycyberchallenge.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycyberchallenge.R
import com.example.mycyberchallenge.models.Puzzle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_book.view.*
import kotlinx.android.synthetic.main.item_puzzle.view.*

class PuzzleAdapter (
    val items: ArrayList<Puzzle>
):RecyclerView.Adapter<PuzzleAdapter.ViewHolder>() {

    override fun getItemCount() = items.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_puzzle, parent, false)
        )

    override fun onBindViewHolder(holder: PuzzleAdapter.ViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bindData(type: Puzzle) {
        itemView.puzzlePrice.text = type.price

        Picasso
            .get()
            .load(type.imageUrl)
            .into(itemView.puzzleImage)

    }
    }
}