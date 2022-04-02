package com.recipe.api.functional;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

import java.util.Objects;
import java.util.function.Consumer;


public final class RecipeBuilder {

    private ShapedRecipe recipe;
    private final NamespacedKey key;

    public static RecipeBuilder of(Plugin plugin, String key) {
        return (new RecipeBuilder(new NamespacedKey(plugin, key)));
    }

    private RecipeBuilder(NamespacedKey key) {
        this.key = Objects.requireNonNull(key, "NamespacedKey");
    }

    private void transformKey(Consumer<NamespacedKey> key) {
        NamespacedKey k = this.key;
        key.accept(k);
    }

    public RecipeBuilder transformRecipe(Consumer<ShapedRecipe> recipe) {
        ShapedRecipe r = this.recipe;
        if (r != null) {
            recipe.accept(r);
        }

        return this;
    }

    public void setResult(ItemStack item) { this.transformKey((key) -> recipe = new ShapedRecipe(key, item)); }

    public RecipeBuilder shape(String row1, String row2, String row3) {
        this.transformRecipe((recipe) -> recipe.shape(row1, row2, row3));
        return this;
    }

    public void setIngredient(char key, Material ingredient) { this.transformRecipe((recipe) -> recipe.setIngredient(key, ingredient)); }

    public RecipeBuilder apply(Consumer<RecipeBuilder> consumer) {
        consumer.accept(this);
        return this;
    }

    public ShapedRecipe build() { return this.recipe; }
}
