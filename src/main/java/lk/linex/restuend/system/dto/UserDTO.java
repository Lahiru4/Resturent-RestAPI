package lk.linex.restuend.system.dto;


import lk.linex.restuend.system.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private int id;
    private String email;
    private Role role;
    private String username;
    private String password;
}
