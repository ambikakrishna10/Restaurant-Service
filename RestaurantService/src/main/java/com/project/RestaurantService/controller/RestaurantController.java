package com.project.RestaurantService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.RestaurantService.model.Restaurant;
import com.project.RestaurantService.repo.RestaurantRepo;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {

	@Autowired
	RestaurantRepo restaurantRepo;
	
	@PostMapping("createRes")
	Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantRepo.save(restaurant);
	}
	
	@GetMapping("/getAllRes")
	List<Restaurant> getAllRestaurants(){
		return restaurantRepo.findAll();
	}
}
