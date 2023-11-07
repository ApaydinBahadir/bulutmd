package bulutmd.foodbackend.dataAccess.abstracts;

import bulutmd.foodbackend.entities.concrete.Food;
import bulutmd.foodbackend.entities.concrete.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {

    @Query(value = "Select y from Food y WHERE y.name = :foodName")
    Food getFoodDataByFoodName(String foodName);

    @Query("SELECT u FROM Order u WHERE u.name = ?1")
    List<Order> getOrderDataByName(String customerName);
}
