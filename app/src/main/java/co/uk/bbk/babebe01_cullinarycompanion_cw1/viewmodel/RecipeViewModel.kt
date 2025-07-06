package co.uk.bbk.babebe01_cullinarycompanion_cw1.viewmodel

import android.app.Application
import androidx.lifecycle.*
import co.uk.bbk.babebe01_cullinarycompanion_cw1.data.RecipeDatabase
import co.uk.bbk.babebe01_cullinarycompanion_cw1.model.Recipe
import co.uk.bbk.babebe01_cullinarycompanion_cw1.repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: RecipeRepository
    val allRecipes: LiveData<List<Recipe>>

    init {
        val dao = RecipeDatabase.getDatabase(application).recipeDao()
        repository = RecipeRepository(dao)
        allRecipes = repository.allRecipes
    }

    fun insert(recipe: Recipe) = viewModelScope.launch {
        repository.insert(recipe)
    }

    fun delete(recipe: Recipe) = viewModelScope.launch {
        repository.delete(recipe)
    }
}
