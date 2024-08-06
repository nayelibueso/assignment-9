package com.coderscampus.Assignment9.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9.domain.Recipe;

@Service
public class RecipeService {
	private List<Recipe> recipes = new ArrayList<>();
}
