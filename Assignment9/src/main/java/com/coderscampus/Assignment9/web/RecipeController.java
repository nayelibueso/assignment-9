package com.coderscampus.Assignment9.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.service.RecipeService;

//Acts as the interface between the user (front end) and the service layer (RecipeService)
//Maps HTTP request (GET Requests) to specific methods 
//Calls the 'RecipeService' to get the data and returns it as a response 
@RestController
public class RecipeController {
//	@Autowired
	public RecipeService recipeService; //Instance of RecipeService class
	@Autowired
	public RecipeController ( RecipeService recipeService) {
		this.recipeService = recipeService;
	}
//	/gluten-free returns gluten-free recipes.
	@GetMapping("/gluten-free") //Made to handle GET request
	public List<Recipe> glutenFreeRecipes() throws IOException {
		recipeService.loadRecipes(); //Ensures recipes are loaded before filtering 
		return recipeService.glutenFreeRecipes();
	}
//	/vegan returns vegan recipes.
	@GetMapping("/vegan")
	public List<Recipe> veganRecipes() throws IOException {
		recipeService.loadRecipes();
		return recipeService.veganRecipes();
	}
//	/vegan-and-gluten-free returns recipes that are both vegan and gluten-free.
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> veganAndGlutenFreeRecipes() throws IOException {
		recipeService.loadRecipes();
		return recipeService.veganAndGlutenFreeRecipes();
	}
//	/vegetarian returns vegetarian recipes.
	@GetMapping("/vegetarian")
	public List<Recipe> vegetarianRecipes() throws IOException{
		recipeService.loadRecipes();
		return recipeService.vegetarianRecipes();
	}
//	/all-recipes returns all recipes without filtering.
	@GetMapping("/all-recipes")
	public List<Recipe> allRecipes() throws IOException {
		recipeService.loadRecipes();
		return recipeService.allRecipes();
	}
	
}
