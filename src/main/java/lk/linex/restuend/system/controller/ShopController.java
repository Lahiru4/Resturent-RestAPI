package lk.linex.restuend.system.controller;

import lk.linex.restuend.system.service.impl.ShopServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shop")
@CrossOrigin
@RequiredArgsConstructor
public class ShopController {
    private final ShopServiceImpl shopServiceImpl;

    public ResponseEntity<?> registerShop(){
        return null;
    }

}
