package lk.linex.restuend.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {
    private int id;
    //shop info
    private String name;
    private String address;
    private String city;
    private String email;
    private String phone;
    private String logo;
    //owner info
    private String ownerName;
    private String ownerEmail;
    private String ownerPhone;
    private String ownerAddress;
    private String ownerNIC;
    private String ownerPassword;
    private String ownerProfilePic;
    private String createdDate;

}
