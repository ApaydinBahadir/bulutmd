package bulutmd.foodbackend.dataAccess.abstracts;

import bulutmd.foodbackend.entities.concrete.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodDao extends JpaRepository<Food,Integer> {

}
