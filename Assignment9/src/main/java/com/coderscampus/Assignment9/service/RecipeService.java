package com.coderscampus.Assignment9.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9.domain.Recipe;
//Will be loading and parsing the 'recipes.txt' using Apache commons CSVS
//Storing parsed data into a collection
//Providing methods to filter the recipes based on specific criteria
@Service
public class RecipeService {
	private List<Recipe> recipes = new ArrayList<>();
}
