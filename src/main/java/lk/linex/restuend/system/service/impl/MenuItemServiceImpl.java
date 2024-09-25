package lk.linex.restuend.system.service.impl;

import lk.linex.restuend.system.dto.MenuItemDTO;
import lk.linex.restuend.system.entity.MenuItem;
import lk.linex.restuend.system.repo.MenuItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuItemServiceImpl {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItemDTO> getAllMenuItems() throws IOException {
        List<MenuItem> all = menuItemRepository.findAll();
        List<MenuItemDTO> allDto = new ArrayList<>(); // Initialize the list
        for (MenuItem menuItem : all) {
            String filePath = menuItem.getFilePath();
            byte[] images = new byte[0];
            try {
                images = Files.readAllBytes(new File(filePath).toPath());
            } catch (IOException e) {
                System.err.println("Error reading file: " + filePath);
            }
            MenuItemDTO mapDto = modelMapper.map(menuItem, MenuItemDTO.class);
            mapDto.setImage(images);
            allDto.add(mapDto);
        }
        return allDto;
    }


    public MenuItemDTO createMenuItem(MenuItemDTO menuItemDTO) throws IOException {
        MenuItem save = menuItemRepository.save(modelMapper.map(menuItemDTO, MenuItem.class));

        String projectPath = System.getProperty("user.dir");

        String filePath = projectPath + "\\src\\main\\resources\\static\\" + save.getId() + ".png";

        save.setFilePath(filePath);

        MultipartFile file = menuItemDTO.getFile();

        file.transferTo(new File(filePath));

        MenuItem update = menuItemRepository.save(save);


        return modelMapper.map(update, MenuItemDTO.class);
    }

    public MenuItemDTO updateMenuItem(MenuItemDTO menuItemDTO) throws IOException {
        MenuItem update = menuItemRepository.save(modelMapper.map(menuItemDTO, MenuItem.class));

        String projectPath = System.getProperty("user.dir");

        String filePath = projectPath + "\\src\\main\\resources\\static\\" + update.getId() + ".png";

        update.setFilePath(filePath);

        MultipartFile file = menuItemDTO.getFile();


        file.transferTo(new File(filePath));


        MenuItem imageUpdate = menuItemRepository.save(update);


        return modelMapper.map(imageUpdate, MenuItemDTO.class);
    }

    public boolean deleteMenuItem(int id) {
        try {
            // Check if the menu item exists before attempting to delete
            if (menuItemRepository.existsById(id)) {
                // Delete the menu item by ID
                menuItemRepository.deleteById(id);
                return true;  // Deletion successful
            } else {
                return false;  // Menu item doesn't exist
            }
        } catch (Exception e) {
            return false;  // Deletion failed due to an exception
        }
    }


    public boolean deleteImage(String path) {
        File directory = new File(path);

        // Check if the provided path is a directory
        if (!directory.isDirectory()) {
            System.out.println("Provided path is not a directory.");
            return false;
        }

        // Get all files in the directory
        File[] files = directory.listFiles();

        // Check if files are null (in case directory is invalid or empty)
        if (files == null || files.length == 0) {
            System.out.println("No files found in the directory.");
            return false;
        }

        boolean deleted = false;

        // Iterate through the files and delete .png files
        for (File file : files) {
            if (file.getName().endsWith(".png")) {
                if (file.delete()) {
                    deleted = true;  // At least one file was successfully deleted
                } else {
                    System.out.println("Failed to delete file: " + file.getName());
                }
            }
        }

        return deleted;  // Return true if at least one file was deleted
    }

}
