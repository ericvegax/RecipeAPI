package com.recipe.api;

import com.recipe.RecipePlugin;
import com.recipe.api.functional.RecipeBuilder;

public class RecipeAPI {

    private static RecipeAPI instance;
    private RecipePlugin recipePlugin;
    private RecipeBuilder recipeBuilder;

    public static RecipeAPI getRecipeAPI() {
        if (instance == null)
            instance = new RecipeAPI();

        return instance;
    }

    public RecipePlugin getPlugin() {
        return recipePlugin;
    }
}
