package com.lgi.theweschshop.shopdata.dao.Impl;

import com.lgi.theweschshop.shopdata.dao.AbstractGenericDAO;
import com.lgi.theweschshop.shopdata.dao.ElementDAO;
import com.lgi.theweschshop.shopdata.entity.Element;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Igor Yurchenko on 10/26/17.
 */
@Repository
public class ElementDAOImpl extends AbstractGenericDAO<Element> implements ElementDAO {

    @Override
    public List<Element> findAllElements() {
        Query query = entityManager.createQuery( "select t from Element t" );
        List<Element> list = query.getResultList();
        return list;
    }



}
