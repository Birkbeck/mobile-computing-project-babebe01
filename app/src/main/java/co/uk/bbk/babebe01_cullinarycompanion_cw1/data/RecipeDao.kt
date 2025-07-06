package co.uk.bbk.babebe01_cullinarycompanion_cw1.data

import androidx.lifecycle.LiveData
import androidx.room.*
import co.uk.bbk.babebe01_cullinarycompanion_cw1.model.Recipe

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: Recipe)

    @Delete
    suspend fun delete(recipe: Recipe)

    @Query("SELECT * FROM recipes ORDER BY id DESC")
    fun getAllRecipes(): LiveData<List<Recipe>>
}
