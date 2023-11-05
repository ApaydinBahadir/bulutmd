package bulutmd.foodbackend.api.controller;

import bulutmd.foodbackend.business.abstracts.FoodService;
import bulutmd.foodbackend.core.utilities.results.Result;
import bulutmd.foodbackend.entities.dtos.FoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/foods")
public class FoodsController {

    private FoodService foodService;

    @Autowired
    public FoodsController(FoodService foodService){
        super();
        this.foodService = foodService;
    }

    @PostMapping(value = "/addFood")
    public Result addFoodToDatabase(@RequestBody FoodDTO foodDTO){
        return this.foodService.addFood(foodDTO);
    }
    @GetMapping(value = "/getFoods")
    public Result getFoods(){
        return this.foodService.getFoods();
    }

}
