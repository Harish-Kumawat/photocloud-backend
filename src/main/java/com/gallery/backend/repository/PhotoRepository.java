package com.gallery.backend.repository;

import com.gallery.backend.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findAllByOrderByUploadedAtDesc();
    List<Photo> findByFavoriteTrueOrderByUploadedAtDesc();
    List<Photo> findByAlbumIdOrderByUploadedAtDesc(Long albumId);
    List<Photo> findByAlbumIsNullOrderByUploadedAtDesc();
}
