package com.gallery.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String publicId;

    @Column
    private String mediaType;

    @Column(nullable = false)
    private LocalDateTime uploadedAt;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean favorite = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_id")
    private Album album;

    @PrePersist
    public void prePersist() {
        uploadedAt = LocalDateTime.now();
    }
}
