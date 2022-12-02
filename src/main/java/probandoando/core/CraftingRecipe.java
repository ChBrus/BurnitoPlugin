package probandoando.core;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class CraftingRecipe {
    public static ShapedRecipe recipeSaddle() {
        ItemStack saddle = new ItemStack(Material.SADDLE);

        ShapedRecipe recipe = new ShapedRecipe(saddle);
        // Leather Leather Leather
        // Stick    Stick   Stick
        // Stick Iron_Ingot Stick
        recipe.shape("LLL", "SSS", "SIS");

        recipe.setIngredient('L', Material.LEATHER);
        recipe.setIngredient('S', Material.STICK);
        recipe.setIngredient('I', Material.IRON_INGOT);

        return recipe;

    }
}
