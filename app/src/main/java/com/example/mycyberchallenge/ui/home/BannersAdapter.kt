package com.example.mycyberchallenge.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycyberchallenge.R
import com.example.mycyberchallenge.models.Banner
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_banner.view.*

class BannersAdapter(
    private val banners: ArrayList<Banner>
): RecyclerView.Adapter<BannersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
    )

    override fun getItemCount() = banners.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(banners[position])
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bindData(banner: Banner) {
            Picasso
                .get()
                .load(banner.imageUrl)
                .into(itemView.bannerImageView)
        }
    }
}