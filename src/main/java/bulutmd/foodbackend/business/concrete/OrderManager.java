package bulutmd.foodbackend.business.concrete;

import bulutmd.foodbackend.business.abstracts.OrderService;
import bulutmd.foodbackend.core.utilities.results.DataResult;
import bulutmd.foodbackend.core.utilities.results.Result;
import bulutmd.foodbackend.dataAccess.abstracts.OrderDao;
import bulutmd.foodbackend.entities.concrete.Order;
import bulutmd.foodbackend.entities.dtos.OrderRequestDTO;
import bulutmd.foodbackend.entities.dtos.OrderRespondDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderManager implements OrderService {

    private final OrderDao orderDao;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderManager(OrderDao orderDao,ModelMapper modelMapper){
        super();
        this.orderDao = orderDao;
        this.modelMapper = modelMapper;
    }

//    Yeni bir order yaratmaya yarayan fonksiyon. Alınan orderRequstDTO
//    dosyalarını Order classına çevirdikten sonra databaseden yemeği ve fiyatını
//    çekip oluşturduğumuz objeye ekliyor ve databaseye kaydediyor
    @Override
    public Result createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = modelMapper.map(orderRequestDTO,Order.class);
        if(orderDao.getFoodDataByFoodName("pii").getFood() == null){
            return new Result(false,"This food not exist.");
        }
        order.setFood(orderDao.getFoodDataByFoodName("pii").getFood());
        order.setPrice(orderDao.getFoodDataByFoodName("pii").getFood().getPrice());
        orderDao.save(order);
        return new Result(true,"Order created.");
    }

//    Kullanıcıdan alınan isim parametresiyle birlikte tüm order kayıtlarını
//    JPA'dan isime göre çekmeye yarıyor. Gelen tüm verileri bir listenin içine atıp
//    listeyi döndürüyor.
    @Override
    public Result getOrderByName(String name) {
        List<Order> orders = orderDao.getOrderDataByName(name);
        if(orders == null){
            return new Result(false,"There is no orders by that name");
        }
        List<OrderRespondDTO> orderRespondDTOS = orders.stream().map(order->modelMapper.map(order,OrderRespondDTO.class)).collect(Collectors.toList());
        return new DataResult(orderRespondDTOS,true,"All orders listed by customer name");
    }

//    Tüm order verilerini databaseden çekip onları OrderRespondDTO
//    verisi olarak kullanıcya dönüyor
    @Override
    public Result getAllOrder() {
        List<Order> orders = orderDao.findAll();
        List<OrderRespondDTO> foodDTOS = orders.stream().map(order->modelMapper.map(order, OrderRespondDTO.class)).collect(Collectors.toList());
        return new DataResult(foodDTOS,true,"All order data returned.");
    }
}
