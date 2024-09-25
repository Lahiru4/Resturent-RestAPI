package lk.linex.restuend.system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemDTO {
    private int id;
    private String code;
    private String name;
    private String description;
    private String price;
    private String category;
    private MultipartFile file;
    private byte[] image;
}
