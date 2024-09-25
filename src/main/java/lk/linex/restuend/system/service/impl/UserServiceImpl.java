package lk.linex.restuend.system.service.impl;

import jakarta.transaction.Transactional;
import lk.linex.restuend.system.dto.UserDTO;
import lk.linex.restuend.system.repo.UserRepository;
import lk.linex.restuend.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;


    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userRepo.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public void save(UserDTO user) {

    }
}
