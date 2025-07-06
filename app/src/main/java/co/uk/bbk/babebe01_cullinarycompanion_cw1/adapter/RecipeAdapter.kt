package co.uk.bbk.babebe01_cullinarycompanion_cw1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.uk.bbk.babebe01_cullinarycompanion_cw1.R
import co.uk.bbk.babebe01_cullinarycompanion_cw1.model.Recipe

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    private var recipeList: List<Recipe> = listOf()

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tvRecipeName)
        val categoryTextView: TextView = itemView.findViewById(R.id.tvRecipeCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.nameTextView.text = recipe.name
        holder.categoryTextView.text = recipe.category
    }

    override fun getItemCount(): Int = recipeList.size

    fun submitList(list: List<Recipe>) {
        recipeList = list
        notifyDataSetChanged()
    }
}
