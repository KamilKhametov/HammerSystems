package com.example.hammersystems.feature.menu.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystems.R
import com.example.hammersystems.databinding.ItemCategoryBinding
import com.example.hammersystems.feature.menu.domain.model.CategoryEntity

class CategoriesAdapter(
    private val onCategoryClick: (selectedPosition: Int) -> Unit
) : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private var selectedItemPos = 0
    private var lastItemSelectedPos = -1

    private val categoriesList = arrayListOf<CategoryEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoriesViewHolder(
        itemBinding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(categoriesList[position])
    }

    override fun getItemCount() = categoriesList.size

    fun setCategories(list: List<CategoryEntity>){
        categoriesList.run {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    inner class CategoriesViewHolder(private val itemBinding: ItemCategoryBinding) : RecyclerView.ViewHolder(itemBinding.root){

        fun bind(model: CategoryEntity){

            with(itemBinding) {
                categoryName.text = model.name

                if (selectedItemPos == NOT_SELECTED) {
                    categoryName.setBackgroundResource(R.drawable.category_off)
                    categoryName.setTextColor(itemView.resources.getColor(R.color.ui_grey_c3c4c9))
                } else {
                    if (selectedItemPos == bindingAdapterPosition) {
                        categoryName.setBackgroundResource(R.drawable.category_on)
                        categoryName.setTextColor(itemView.resources.getColor(R.color.ui_primary_purple))
                    } else {
                        categoryName.setBackgroundResource(R.drawable.category_off)
                        categoryName.setTextColor(itemView.resources.getColor(R.color.ui_grey_c3c4c9))
                    }
                }

                itemView.setOnClickListener {

                    if (selectedItemPos == bindingAdapterPosition) {
                        notifyItemChanged(bindingAdapterPosition)
                    } else {
                        lastItemSelectedPos = selectedItemPos
                        selectedItemPos = bindingAdapterPosition

                        notifyItemChanged(lastItemSelectedPos, Unit)
                        notifyItemChanged(selectedItemPos, Unit)
                    }

                    onCategoryClick.invoke(selectedItemPos)
                }
            }
        }
    }

    companion object{

        const val NOT_SELECTED = -1
    }
}