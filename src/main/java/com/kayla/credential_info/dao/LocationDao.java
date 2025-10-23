package com.kayla.credential_info.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kayla.credential_info.entity.Location;

public interface LocationDao extends JpaRepository<Location, Long> {

    Optional<Location> findById(String locationId);

}
