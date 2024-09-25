package lk.linex.restuend.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    private String description;
    private String price;
    private String category;
    private String filePath;
    @ManyToOne
    private Shop shop;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<OrderDetails> order_details;
}
