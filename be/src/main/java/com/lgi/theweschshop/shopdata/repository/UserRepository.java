package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.EUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Igor Yurchenko on 11/9/17.
 */
@Repository
public interface UserRepository extends JpaRepository<EUser, Long>{

    public EUser findEUserByEmail( String email );

}
