package com.lgi.theweschshop.shopdata.service.impl;

import com.lgi.theweschshop.shopdata.dao.ElementDAO;
import com.lgi.theweschshop.shopdata.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Service("elementService")
public class ElementServiceImpl implements ElementService {

    @Autowired
    private ElementDAO elementDAO;




}
