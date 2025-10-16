/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kayla.credential_info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.kayla.credential_info.controller.model.CredentialController;
import com.kayla.credential_info.dao.LocationData;

class CredentialServiceTestSupport {

    private static final String LOCATION_TABLE = "location";

    // @formatter:off
    private LocationData insertAddress1 = new LocationData(
        1L,
        "123 Main St, Springfield",
        "IL",
        "62701",
        "www.test.com",
        "111-222-test"
    );

    private LocationData insertAddress2 = new LocationData(
        2L,
        "111 First St, Springfield",
        "MO",
        "65801",
        "www.runtime.com",
        "111-111-test"
    );
    //@formatter:on

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CredentialController credentialController;

    protected LocationData buildInsertLocation(int which) {
        // TODO Auto-generated method stub
        return which == 1 ? insertAddress1 : insertAddress2;
    }
    protected int rowsInLocationTable() {
        return JdbcTestUtils.countRowsInTable(jdbcTemplate, LOCATION_TABLE);
    }

    protected LocationData insertLocation(LocationData locationData) {
        Location location = locationData.toLocation();
        LocationData clone = new LocationData(location);

        clone.setLocationID(null);
        return credentialController.createLocation(clone);
    }

    protected List<LocationData> insertTwoLocations() {
        LocationData location1 = insertLocation(buildInsertLocation(1));
        LocationData location2 = insertLocation(buildInsertLocation(2));

        return List.of(location1, location2);
    }

    private List<LocationData> retrieveAllLocations() {
        // TODO Auto-generated method stub
        return credentialController.retrieveAllLocations();
    }

}

