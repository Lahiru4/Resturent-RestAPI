package lk.linex.restuend.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    private String id;
    private String date;
    private String total;
    private String seviceCharge;
    private String discount;
    private String grandTotal;


    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<OrderDetails> order_details;

    @ManyToOne
    private Shop shop;
}
