package com.coderscampus.Assignment9.web;

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
	@Autowired
	public RecipeService recipeService; //Instance of RecipeService class
	
	
//	/gluten-free returns gluten-free recipes.
	@GetMapping("/gluten-free") //Made to handle GET request
	public List<Recipe> glutenFreeRecipes() {
		recipeService.loadRecipes();
		
	}
//	/vegan returns vegan recipes.
//	/vegan-and-gluten-free returns recipes that are both vegan and gluten-free.
//	/vegetarian returns vegetarian recipes.
//	/all-recipes returns all recipes without filtering.
	
}
