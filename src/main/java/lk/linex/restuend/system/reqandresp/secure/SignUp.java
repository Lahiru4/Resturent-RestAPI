package lk.linex.restuend.system.reqandresp.secure;

import lk.linex.restuend.system.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SignUp {
    private int id;
    private String email;
    private String username;
    private String password;
    private Role role;
}

