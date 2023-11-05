package bulutmd.foodbackend.entities.dtos;

import lombok.Data;

@Data
public class OrderRespondDTO {

//    Kullanıcıya döndürelecek order classı için
//    kullanılan DTO.

    private String name;

    private String foodName;

    private float price;
}
