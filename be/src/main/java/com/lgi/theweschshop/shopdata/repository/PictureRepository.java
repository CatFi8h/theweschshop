package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
