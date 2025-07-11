package co.uk.bbk.babebe01_cullinarycompanion_cw1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val ingredients: String,
    val instructions: String,
    val category: String
)
