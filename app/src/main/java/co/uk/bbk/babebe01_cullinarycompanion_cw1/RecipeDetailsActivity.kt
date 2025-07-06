package co.uk.bbk.babebe01_cullinarycompanion_cw1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import co.uk.bbk.babebe01_cullinarycompanion_cw1.model.Recipe
import co.uk.bbk.babebe01_cullinarycompanion_cw1.viewmodel.RecipeViewModel

class RecipeDetailsActivity : AppCompatActivity() {

    private val viewModel: RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        val nameField = findViewById<EditText>(R.id.etName)
        val ingredientsField = findViewById<EditText>(R.id.etIngredients)
        val instructionsField = findViewById<EditText>(R.id.etInstructions)
        val categorySpinner = findViewById<Spinner>(R.id.spinnerCategory)

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val name = nameField.text.toString().trim()
            val ingredients = ingredientsField.text.toString().trim()
            val instructions = instructionsField.text.toString().trim()
            val category = categorySpinner.selectedItem?.toString()?.trim() ?: ""

            if (name.isNotEmpty() && ingredients.isNotEmpty() && instructions.isNotEmpty()) {
                val recipe = Recipe(
                    name = name,
                    ingredients = ingredients,
                    instructions = instructions,
                    category = category
                )
                viewModel.insert(recipe)
                Toast.makeText(this, "Recipe saved", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener {
            Toast.makeText(this, "Delete not implemented in CW2", Toast.LENGTH_SHORT).show()
        }
    }
}
