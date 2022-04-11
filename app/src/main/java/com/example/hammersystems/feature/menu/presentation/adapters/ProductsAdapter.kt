package com.example.hammersystems.feature.menu.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hammersystems.R
import com.example.hammersystems.databinding.ItemProductBinding
import com.example.hammersystems.feature.menu.domain.model.ProductEntity
import com.example.hammersystems.library.coreui.global.extensions.orZero

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    private val productsList = arrayListOf<ProductEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductsViewHolder(
        itemBinding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(productsList[position])
    }

    override fun getItemCount() = productsList.size

    fun setProducts(list: List<ProductEntity>){
        productsList.run {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    class ProductsViewHolder(private val itemBinding: ItemProductBinding) : RecyclerView.ViewHolder(itemBinding.root){

        @SuppressLint("StringFormatMatches")
        fun bind(model: ProductEntity){

            with(itemBinding){

                image.load(model.imageUrl)
                name.text = model.name
                description.text = model.description
                btnBuy.text = itemView.resources.getString(R.string.buy_btn_title, model.quantity)
            }
        }
    }
}