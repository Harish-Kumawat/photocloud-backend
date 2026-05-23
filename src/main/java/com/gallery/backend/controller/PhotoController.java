package com.gallery.backend.controller;

import com.gallery.backend.model.Photo;
import com.gallery.backend.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/photos/public")
    public ResponseEntity<List<Photo>> getAllPhotos() {
        return ResponseEntity.ok(photoService.getAllPhotos());
    }

    @GetMapping("/photos/favorites")
    public ResponseEntity<List<Photo>> getFavorites() {
        return ResponseEntity.ok(photoService.getFavorites());
    }

    @GetMapping("/photos/album/{albumId}")
    public ResponseEntity<List<Photo>> getPhotosByAlbum(@PathVariable Long albumId) {
        return ResponseEntity.ok(photoService.getPhotosByAlbum(albumId));
    }

    @PostMapping("/admin/photos/upload")
    public ResponseEntity<Photo> uploadPhoto(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam(value = "albumId", required = false) Long albumId) throws IOException {
        return ResponseEntity.ok(photoService.uploadPhoto(file, title, albumId));
    }

    @PostMapping("/admin/photos/upload-multiple")
    public ResponseEntity<List<Photo>> uploadMultiple(
            @RequestParam("files") List<MultipartFile> files,
            @RequestParam(value = "titles", required = false) List<String> titles,
            @RequestParam(value = "albumId", required = false) Long albumId) throws IOException {
        return ResponseEntity.ok(photoService.uploadMultiple(files, titles, albumId));
    }

    @PutMapping("/admin/photos/{id}/favorite")
    public ResponseEntity<Photo> toggleFavorite(@PathVariable Long id) throws IOException {
        return ResponseEntity.ok(photoService.toggleFavorite(id));
    }

    @PutMapping("/admin/photos/{id}/album/{albumId}")
    public ResponseEntity<Photo> moveToAlbum(@PathVariable Long id, @PathVariable Long albumId) {
        return ResponseEntity.ok(photoService.moveToAlbum(id, albumId));
    }

    @DeleteMapping("/admin/photos/{id}")
    public ResponseEntity<String> deletePhoto(@PathVariable Long id) throws IOException {
        photoService.deletePhoto(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @GetMapping("/admin/storage")
    public ResponseEntity<Map> getStorageStats() throws Exception {
        return ResponseEntity.ok(photoService.getStorageStats());
    }
}
