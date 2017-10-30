package com.lgi.theweschshop.shopdata.dao;

import com.lgi.theweschshop.shopdata.entity.Element;

import java.util.List;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
public interface ElementDAO extends GenericDAO<Element> {

    List<Element> findAllElements();
}
