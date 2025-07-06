package co.uk.bbk.babebe01_cullinarycompanion_cw1.repository

import androidx.lifecycle.LiveData
import co.uk.bbk.babebe01_cullinarycompanion_cw1.data.RecipeDao
import co.uk.bbk.babebe01_cullinarycompanion_cw1.model.Recipe

class RecipeRepository(private val recipeDao: RecipeDao) {
    val allRecipes: LiveData<List<Recipe>> = recipeDao.getAllRecipes()

    suspend fun insert(recipe: Recipe) = recipeDao.insert(recipe)
    suspend fun delete(recipe: Recipe) = recipeDao.delete(recipe)
}
