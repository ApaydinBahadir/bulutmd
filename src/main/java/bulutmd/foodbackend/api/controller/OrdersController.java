package bulutmd.foodbackend.api.controller;

import bulutmd.foodbackend.business.abstracts.OrderService;
import bulutmd.foodbackend.core.utilities.results.Result;
import bulutmd.foodbackend.entities.dtos.OrderRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/orders")
public class OrdersController {

    private OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService){
        super();
        this.orderService = orderService;
    }

    @PostMapping(value = "/createOrder")
    public Result createOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        return this.orderService.createOrder(orderRequestDTO);
    }
    @PostMapping(value = "/getOrdersByName")
    public Result getOrderByName(@RequestParam String customerName){
        return this.orderService.getOrderByName(customerName);
    }
    @PostMapping(value = "/getAllOrder")
    public Result getAllOrder(){
        return this.orderService.getAllOrder();
    }

}
