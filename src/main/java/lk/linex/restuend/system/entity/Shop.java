package lk.linex.restuend.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    @Id
    private String shop_id;
    private String shop_name;
    private String shop_address;
    private String shop_contact;
    private String shop_email;
    private String shop_owner_name;
    private String shop_owner_contact;
    private String shop_owner_email;
    private String shop_owner_address;
    private String shop_owner_nic;

    @OneToMany(mappedBy = "shop")
    private List<MenuItem> menuItems;
    @OneToMany(mappedBy = "shop")
    private List<Orders> orders;
    @OneToMany(mappedBy = "shop")
    private List<User> users;


}
