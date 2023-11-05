package bulutmd.foodbackend.entities.concrete;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(name = "order_customer_name")
    private String name;

    @Column(name = "order_price")
    private float price;

//    Her Order içerisinde bir tane Food olması gerektiği için ve tersi
//    zorunlu olmadığı için ManyToOne bağlantısı kurulmuştur.
//    Hem fiyat, hemde isim kullanılması gerektiği için id
//    referansı verip JPA ile verileri çekmek daha mantıklı

    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "food_id")
    @JsonBackReference
    private Food food;

}
