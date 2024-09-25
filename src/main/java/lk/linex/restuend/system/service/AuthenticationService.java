package lk.linex.restuend.system.service;


import lk.linex.restuend.system.reqandresp.response.JwtAuthResponse;
import lk.linex.restuend.system.reqandresp.secure.SignIn;
import lk.linex.restuend.system.reqandresp.secure.SignUp;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(SignUp signUp);
    JwtAuthResponse refreshToken(String accessToken);
}
