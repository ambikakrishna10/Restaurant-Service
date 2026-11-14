package com.project.RestaurantService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.RestaurantService.model.FoodItems;

@Repository
public interface FooditemsRepo extends JpaRepository<FoodItems, Integer>{

	List<FoodItems> findByRestaurantId(Integer id);
}
