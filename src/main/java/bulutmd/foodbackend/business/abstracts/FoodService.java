package bulutmd.foodbackend.business.abstracts;

import bulutmd.foodbackend.core.utilities.results.Result;
import bulutmd.foodbackend.entities.dtos.FoodDTO;

public interface FoodService {
    Result addFood(FoodDTO foodDTO);

    Result getFoods();
}
