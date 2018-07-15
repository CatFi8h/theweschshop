package com.lgi.theweschshop.shopdata.service;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
    void saveImage( MultipartFile img, Long elementId );
}
