package lk.linex.restuend.system.controller;

import lk.linex.restuend.system.reqandresp.response.JwtAuthResponse;
import lk.linex.restuend.system.reqandresp.secure.SignIn;
import lk.linex.restuend.system.reqandresp.secure.SignUp;
import lk.linex.restuend.system.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;
    @PostMapping("/signIn")
    public ResponseEntity<JwtAuthResponse> signIn (@RequestBody SignIn signIn){
        //
        System.out.println(signIn);
        return ResponseEntity.ok(authenticationService.signIn(signIn));
    }

    @PostMapping("/signUp")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUpReq) {
        return ResponseEntity.ok(authenticationService.signUp(signUpReq));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthResponse> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }

}
