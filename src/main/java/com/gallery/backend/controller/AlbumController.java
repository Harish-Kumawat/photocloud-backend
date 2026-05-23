package com.gallery.backend.controller;

import com.gallery.backend.model.Album;
import com.gallery.backend.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAllAlbums() {
        return ResponseEntity.ok(albumService.getAllAlbums());
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        return ResponseEntity.ok(albumService.getAlbumById(id));
    }

    @PostMapping("/admin/albums")
    public ResponseEntity<Album> createAlbum(@RequestBody Map<String, String> body) {
        return ResponseEntity.ok(albumService.createAlbum(
                body.get("name"),
                body.get("description")
        ));
    }

    @PutMapping("/admin/albums/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return ResponseEntity.ok(albumService.updateAlbum(
                id,
                body.get("name"),
                body.get("description")
        ));
    }

    @DeleteMapping("/admin/albums/{id}")
    public ResponseEntity<String> deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return ResponseEntity.ok("Album deleted successfully");
    }
}
