package com.project.RestaurantService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.RestaurantService.model.FoodItems;
import com.project.RestaurantService.repo.FooditemsRepo;

@RestController
@RequestMapping("fooditems")
public class FoodItemsController {

	@Autowired
	FooditemsRepo fooditemsRepo;

	@PostMapping("createFoodItems")
	FoodItems createFoodItems(@RequestBody FoodItems foodItems) {
		return fooditemsRepo.save(foodItems);
	}

	@GetMapping("getAllFoodItems")
	List<FoodItems> getFoodItems() {
		return fooditemsRepo.findAll();
	}

	@GetMapping("getAllFoodItems/{id}")
	List<FoodItems> getFoodItemsByRestaurantId(@PathVariable Integer id) {
		return fooditemsRepo.findByRestaurantId(id);
	}

	@PutMapping("/updateFoodItems/{id}")
	FoodItems updateFoodItems(@RequestBody FoodItems foodItems, @PathVariable Integer id) {

		FoodItems FoodItemsFromDb = fooditemsRepo.findById(id).get();
		FoodItemsFromDb.setName(foodItems.getName());
		FoodItemsFromDb.setPrice(foodItems.getPrice());
		FoodItemsFromDb.setRestaurant(foodItems.getRestaurant());

		return fooditemsRepo.save(FoodItemsFromDb);
	}

	@DeleteMapping
	String deleteFoodItems(@PathVariable Integer id) {
		fooditemsRepo.deleteById(id);
		return "Successfully deleted food items form foodItems Id: " + id;
	}
}
