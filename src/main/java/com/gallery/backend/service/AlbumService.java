package com.gallery.backend.service;

import com.gallery.backend.model.Album;
import com.gallery.backend.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album createAlbum(String name, String description) {
        Album album = new Album();
        album.setName(name);
        album.setDescription(description);
        return albumRepository.save(album);
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAllByOrderByCreatedAtDesc();
    }

    public Album getAlbumById(Long id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album not found"));
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

    public Album updateAlbum(Long id, String name, String description) {
        Album album = getAlbumById(id);
        album.setName(name);
        album.setDescription(description);
        return albumRepository.save(album);
    }
}
