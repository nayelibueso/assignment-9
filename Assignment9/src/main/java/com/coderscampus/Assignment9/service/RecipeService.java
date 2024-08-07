package com.coderscampus.Assignment9.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9.domain.Recipe;

//Will be loading and parsing the 'recipes.txt' using Apache commons CSVS
//Storing parsed data into a collection
//Providing methods to filter the recipes based on specific criteria
@Service // Service class that handles the buisnuess logic of this class
public class RecipeService {
	private List<Recipe> recipes = new ArrayList<>();

	public void loadRecipes() throws IOException {
		Reader in = new FileReader("recipes.txt");
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().withHeader().withEscape('\\').parse(in);
		for (CSVRecord record : records) {
			Recipe recipe = new Recipe();
			recipe.setCookingMinutes(Integer.parseInt(record.get(0))); //Setting each fields for the 'Recipe' class
			recipe.setDairyFree(Boolean.parseBoolean(record.get(1)));
			recipe.setGlutenFree(Boolean.parseBoolean(record.get(2)));
			recipe.setInstructions(record.get(3));
			recipe.setPreparationMinutes(Double.parseDouble(record.get(4)));
			recipe.setPricePerServing(Double.parseDouble(record.get(5)));
			recipe.setReadyInMinutes(Integer.parseInt(record.get(6)));
			recipe.setServings(Integer.parseInt(record.get(7)));
			recipe.setSpoonacularScore(Double.parseDouble(record.get(8)));
			recipe.setTitle(record.get(9));
			recipe.setVegan(Boolean.parseBoolean(record.get(10)));
			recipe.setVegetarian(Boolean.parseBoolean(record.get(11)));
			recipes.add(recipe);
		}
	}

	public List<Recipe> glutenFreeRecipes() {
		return recipes.stream()
				      .filter(Recipe::getGlutenFree)
				      .collect(Collectors.toList());
	}

	public List<Recipe> veganRecipes() {
		return recipes.stream()
				      .filter(Recipe::getVegan)
				      .collect(Collectors.toList());
	}

	public List<Recipe> veganAndGlutenFreeRecipes() {
		return recipes.stream()
				      .filter(Recipe::getGlutenFree)
				      .filter(Recipe::getVegan)
				      .collect(Collectors.toList());
	}

	public List<Recipe> vegetarianRecipes() {
		return recipes.stream()
				      .filter(Recipe::getVegetarian)
				      .collect(Collectors.toList());
	}

	public List<Recipe> allRecipes() {
		return recipes;
	}
}
