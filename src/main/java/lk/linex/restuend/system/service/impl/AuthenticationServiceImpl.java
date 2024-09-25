package lk.linex.restuend.system.service.impl;


import lk.linex.restuend.system.dto.UserDTO;
import lk.linex.restuend.system.entity.User;
import lk.linex.restuend.system.repo.UserRepository;
import lk.linex.restuend.system.reqandresp.response.JwtAuthResponse;
import lk.linex.restuend.system.reqandresp.secure.SignIn;
import lk.linex.restuend.system.reqandresp.secure.SignUp;
import lk.linex.restuend.system.service.AuthenticationService;
import lk.linex.restuend.system.service.JwtService;
import lk.linex.restuend.system.util.RespList;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepo;
    private final JwtService jwtService;


    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;

    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        var userByEmail = userRepo.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generatedToken = jwtService.generateToken(userByEmail);
        return JwtAuthResponse.builder().token(generatedToken).message(RespList.RSP_SUCCESS).build();
    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        String email = signUp.getEmail();
        Optional<User> byEmail = userRepo.findByEmail(email);
        if (byEmail.isPresent()) {
            return JwtAuthResponse.builder().token(null).message(RespList.RSP_DUPLICATED + "EMAIL").build();
        }
        String username = signUp.getUsername();
        Optional<User> byUsername = userRepo.findByUsername(username);
        if (byUsername.isPresent()) {
            return JwtAuthResponse.builder().token(null).message(RespList.RSP_DUPLICATED + "USERNAME").build();
        }
        var buildUser = UserDTO.builder()
                .username(signUp.getUsername())
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(signUp.getRole())
                .build();
        var savedUser = userRepo.save(modelMapper.map(buildUser, User.class));
        var genToken = jwtService.generateToken(savedUser);
        return JwtAuthResponse.builder().token(genToken).message(RespList.RSP_SUCCESS).build();
    }

    @Override
    public JwtAuthResponse refreshToken(String accessToken) {
        var userName = jwtService.extractUsername(accessToken);
        var userEntity = userRepo.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.generateToken(userEntity);
        return JwtAuthResponse.builder().token(refreshToken).build();
    }
}
