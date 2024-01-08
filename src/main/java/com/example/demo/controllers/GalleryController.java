package com.example.demo.controllers;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GalleryController {

    private static final String IMAGE_DIR = "/path/to/your/images/";

    @GetMapping("/image/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) throws IOException, MalformedURLException {
        Path imagePath = Paths.get(IMAGE_DIR + imageName);
        Resource resource = new UrlResource(imagePath.toUri());
        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Set appropriate image content type
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
