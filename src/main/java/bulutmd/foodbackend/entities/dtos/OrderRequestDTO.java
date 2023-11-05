package bulutmd.foodbackend.entities.dtos;

import lombok.Data;

@Data
public class OrderRequestDTO {

//    Order sınıfı için kullanıcıdan alınacak bilgiler için
//    oluşturulmuş DTO. Fiyat etiketi yok çünkü onu Food clasından
//    çekmek daha uygun olacaktır.

    private String name;

    private String foodName;
}
