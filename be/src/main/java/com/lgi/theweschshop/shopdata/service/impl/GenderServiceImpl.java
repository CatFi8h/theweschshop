package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.enums.Gender;
import com.lgi.theweschshop.shopdata.service.GenderService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("genderService")
public class GenderServiceImpl implements GenderService {

    @Override
    public List<Gender> getAllGender() {
        return Arrays.asList( Gender.values() );
    }
}
