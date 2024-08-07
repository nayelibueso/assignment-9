package com.coderscampus.Assignment9.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9.domain.Recipe;
//Will be loading and parsing the 'recipes.txt' using Apache commons CSVS
//Storing parsed data into a collection
//Providing methods to filter the recipes based on specific criteria
@Service
public class RecipeService {
	private List<Recipe> recipes = new ArrayList<>();
	
	public void loadRecipes () throws IOException {
		Reader in = new FileReader("recipes.txt");
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().withHeader().parse(in);
		for (CSVRecord record : records) {
			String cookingMinutes = record.get(0);
			Boolean dairyFree = Boolean.parseBoolean(record.get(1));
			Boolean glutenFree = Boolean.parseBoolean(record.get(2));
			String instructions = record.get(3);
			Double preperationMinutes = Double.parseDouble(record.get(4));
			Double pricePerServing = Double.parseDouble(record.get(5));
			Integer readyInMinutes = Integer.parseInt(record.get(6));
			Integer servings = Integer.parseInt(record.get(7));
			Double spoonacularScore = Double.parseDouble(record.get(8));
			String title = record.get(9);
			Boolean vegan = Boolean.parseBoolean(record.get(10));
			Boolean vegetarian = Boolean.parseBoolean(record.get(11)); 
			
		}
	}
}
