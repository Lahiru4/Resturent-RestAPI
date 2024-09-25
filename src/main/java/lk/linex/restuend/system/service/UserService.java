package lk.linex.restuend.system.service;

import lk.linex.restuend.system.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    void save(UserDTO user);
}
