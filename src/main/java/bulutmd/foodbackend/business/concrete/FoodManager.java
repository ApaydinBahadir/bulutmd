package bulutmd.foodbackend.business.concrete;

import bulutmd.foodbackend.business.abstracts.FoodService;
import bulutmd.foodbackend.core.utilities.results.DataResult;
import bulutmd.foodbackend.core.utilities.results.Result;
import bulutmd.foodbackend.dataAccess.abstracts.FoodDao;
import bulutmd.foodbackend.entities.concrete.Food;
import bulutmd.foodbackend.entities.dtos.FoodDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodManager implements FoodService {

    private final FoodDao foodDao;
    private final ModelMapper modelMapper;

    public FoodManager(FoodDao foodDao,ModelMapper modelMapper){
        super();
        this.foodDao = foodDao;
        this.modelMapper = modelMapper;
    }

//    Kullanıcıdan alınan isim ve fiyatları DTO'dan food classına çeviriyor
//    ve databaseye ekliyor
    @Override
    public Result addFood(FoodDTO foodDTO) {
        Food food = modelMapper.map(foodDTO, Food.class);
        if(food == null){
            return new Result(false,"Food is not saved");
        }
        foodDao.save(food);
        return new Result(true,"Food is saved to database");
    }

//    Tüm food verilerini databaseden çekip kullanıcıya FoodDTO olarak döndürüyor
    @Override
    public Result getFoods() {
        List<Food> foods = foodDao.findAll();
        List<FoodDTO> foodDTOS = foods.stream().map(food->modelMapper.map(food,FoodDTO.class)).collect(Collectors.toList());

        if(foodDTOS.isEmpty()){
            return new Result(false,"Data couldn't fetch.");
        }

        return new DataResult(foodDTOS,true,"All food data returned.");
    }
}
