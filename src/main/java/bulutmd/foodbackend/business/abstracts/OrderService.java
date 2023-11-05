package bulutmd.foodbackend.business.abstracts;

import bulutmd.foodbackend.core.utilities.results.Result;
import bulutmd.foodbackend.entities.dtos.OrderRequestDTO;
import bulutmd.foodbackend.entities.dtos.OrderRespondDTO;

public interface OrderService {
    Result createOrder(OrderRequestDTO orderRequestDTO);

    Result getOrderByName(String name);

    Result getAllOrder();

}
