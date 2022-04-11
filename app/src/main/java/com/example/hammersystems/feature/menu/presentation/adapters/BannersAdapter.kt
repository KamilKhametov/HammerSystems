package com.example.hammersystems.feature.menu.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.hammersystems.databinding.ItemBannerBinding

class BannersAdapter : RecyclerView.Adapter<BannersAdapter.BannersViewHolder>() {

    private val bannersList = arrayListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BannersViewHolder(
        itemBinding = ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: BannersViewHolder, position: Int) {
        holder.bind(bannersList[position])
    }

    override fun getItemCount() = bannersList.size

    fun setBanners(list: List<Int>){
        bannersList.run {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    inner class BannersViewHolder(private val itemBinding: ItemBannerBinding) : RecyclerView.ViewHolder(itemBinding.root){

        fun bind(imageUrl: Int){

            itemBinding.imageView.load(imageUrl){
                transformations(RoundedCornersTransformation(ROUND_CORNER_VALUE))
            }
        }
    }

    private companion object{
        const val ROUND_CORNER_VALUE = 10f
    }
}