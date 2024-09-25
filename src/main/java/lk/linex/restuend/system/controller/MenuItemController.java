package lk.linex.restuend.system.controller;

import lk.linex.restuend.system.dto.MenuItemDTO;
import lk.linex.restuend.system.dto.ResponseDTO;
import lk.linex.restuend.system.service.impl.MenuItemServiceImpl;
import lk.linex.restuend.system.util.RespList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menu")
public class MenuItemController {

    private final MenuItemServiceImpl menuItemServiceImpl;

    private final ResponseDTO responseDTO;


    @PostMapping(value = "/create", consumes = "multipart/form-data")
    public ResponseEntity<?> createMenuItem(
            @RequestPart("menuItem") MenuItemDTO menuItemDTO,
            @RequestPart("file") MultipartFile file) {
        try {
            menuItemDTO.setFile(file);
            MenuItemDTO menuItem = menuItemServiceImpl.createMenuItem(menuItemDTO);
            if (menuItem!=null) {
                responseDTO.setCode(RespList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(menuItem);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            } else {
                responseDTO.setCode(RespList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseDTO.setCode(RespList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(null);
            e.printStackTrace();
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllMenuItems() {
        try {
            List<MenuItemDTO> allMenuItems = menuItemServiceImpl.getAllMenuItems();
            if (allMenuItems!=null) {
                responseDTO.setCode(RespList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(allMenuItems);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            } else {
                responseDTO.setCode(RespList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseDTO.setCode(RespList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(null);
            e.printStackTrace();
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "/update", consumes = "multipart/form-data")
    public ResponseEntity<?> updateMenuItem(
            @RequestPart("menuItem") MenuItemDTO menuItemDTO,
            @RequestPart("file") MultipartFile file) {
        try {
            menuItemDTO.setFile(file);
            MenuItemDTO menuItem = menuItemServiceImpl.updateMenuItem(menuItemDTO);
            if (menuItem!=null) {
                responseDTO.setCode(RespList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(menuItem);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            } else {
                responseDTO.setCode(RespList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseDTO.setCode(RespList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(null);
            e.printStackTrace();
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteMenuItem(@PathVariable("id") int id) {
        try {
            boolean isDeleted = menuItemServiceImpl.deleteMenuItem(id);
            if (isDeleted) {
                responseDTO.setCode(RespList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(isDeleted);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            } else {
                responseDTO.setCode(RespList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(isDeleted);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseDTO.setCode(RespList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(null);
            e.printStackTrace();
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
