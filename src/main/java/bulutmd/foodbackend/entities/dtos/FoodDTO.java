package bulutmd.foodbackend.entities.dtos;

import lombok.Data;

@Data
public class FoodDTO {

    //    Kullanıcıya döndürelecek food classı için
    //    kullanılan DTO.

    private String name;

    private float price;
}
