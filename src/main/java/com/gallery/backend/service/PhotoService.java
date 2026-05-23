package com.gallery.backend.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.gallery.backend.model.Album;
import com.gallery.backend.model.Photo;
import com.gallery.backend.repository.AlbumRepository;
import com.gallery.backend.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private Cloudinary cloudinary;

    public Photo uploadPhoto(MultipartFile file, String title, Long albumId) throws IOException {
        String resourceType = "image";
        String contentType = file.getContentType();
        if (contentType != null && contentType.startsWith("video")) {
            resourceType = "video";
        }
        Map uploadResult = cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.asMap("folder", "gallery", "resource_type", resourceType)
        );
        Photo photo = new Photo();
        photo.setTitle(title);
        photo.setImageUrl((String) uploadResult.get("secure_url"));
        photo.setPublicId((String) uploadResult.get("public_id"));
        photo.setMediaType(resourceType);
        if (albumId != null) {
            albumRepository.findById(albumId).ifPresent(photo::setAlbum);
        }
        return photoRepository.save(photo);
    }

    public List<Photo> uploadMultiple(List<MultipartFile> files, List<String> titles, Long albumId) throws IOException {
        List<Photo> uploaded = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            String title = (titles != null && i < titles.size()) ? titles.get(i) : files.get(i).getOriginalFilename();
            uploaded.add(uploadPhoto(files.get(i), title, albumId));
        }
        return uploaded;
    }

    public List<Photo> getAllPhotos() {
        return photoRepository.findAllByOrderByUploadedAtDesc();
    }

    public List<Photo> getFavorites() {
        return photoRepository.findByFavoriteTrueOrderByUploadedAtDesc();
    }

    public List<Photo> getPhotosByAlbum(Long albumId) {
        return photoRepository.findByAlbumIdOrderByUploadedAtDesc(albumId);
    }

    public Photo toggleFavorite(Long id) {
        Photo photo = photoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Photo not found"));
        photo.setFavorite(!photo.isFavorite());
        return photoRepository.save(photo);
    }

    public Photo moveToAlbum(Long photoId, Long albumId) {
        Photo photo = photoRepository.findById(photoId)
                .orElseThrow(() -> new RuntimeException("Photo not found"));
        if (albumId == null) {
            photo.setAlbum(null);
        } else {
            albumRepository.findById(albumId).ifPresent(photo::setAlbum);
        }
        return photoRepository.save(photo);
    }

    public Map getStorageStats() throws Exception {
        return cloudinary.api().usage(ObjectUtils.emptyMap());
    }

    public void deletePhoto(Long id) throws IOException {
        Photo photo = photoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Photo not found"));
        String resourceType = photo.getMediaType() != null ? photo.getMediaType() : "image";
        cloudinary.uploader().destroy(photo.getPublicId(),
                ObjectUtils.asMap("resource_type", resourceType));
        photoRepository.deleteById(id);
    }
}
