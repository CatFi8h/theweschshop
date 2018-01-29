package com.lgi.theweschshop.shopdata.repository;

import com.lgi.theweschshop.shopdata.model.EUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EUserRepository extends JpaRepository<EUser, Long> {
}
