package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.model.Picture;
import com.lgi.theweschshop.shopdata.repository.ElementRepository;
import com.lgi.theweschshop.shopdata.repository.PictureRepository;
import com.lgi.theweschshop.shopdata.service.PictureService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service("pictureService")
public class PictureServiceImpl implements PictureService {

    @Autowired
    PictureRepository pictureRepository;

    @Autowired
    ElementRepository elementRepository;

    @Autowired
    Environment environment;

    @Override
    public void saveImage(MultipartFile img, Long elementId) {

        try {
            Picture picture = new Picture();
            picture.setElementId(elementId);
            byte[] bytes = img.getBytes();
            String originalFilename = img.getOriginalFilename();
            savePictureToDisc(bytes, originalFilename, elementId);
            picture.setPicture(bytes);
            picture.setPictureName(originalFilename);
            pictureRepository.save(picture);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean savePictureToDisc(byte[] bytes, String name, Long elementId) throws IOException {
        String pathToFiles = environment.getProperty("path.pictures") + "/" + elementId;
        File dir = new File(pathToFiles);
        dir.mkdirs();
        FileUtils.writeByteArrayToFile(new File(pathToFiles + "/" + name), bytes);
        return true;
    }

}
