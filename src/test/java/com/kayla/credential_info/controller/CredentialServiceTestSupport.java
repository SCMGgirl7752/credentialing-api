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

    private static final String INSERT_PROVIDER_1_SQL = """
        INSERT INTO provider (provider_id, first_name, last_name, npi_number)
        VALUES (1, 'John', 'Doe', '1234567890');
        """;

    private static final String INSERT_PROVIDER_2_SQL = """
        INSERT INTO provider (provider_id, first_name, last_name, npi_number)
        VALUES (2, 'Jane', 'Smith', '0987654321');
        """;

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

    private LocationData updateAddress1 = new LocationData(
                1L,
        "456 Elm St, Springfield",
        "ID",
        "62702",
        "www.anothertest.com",
        "222-222-test"
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

    protected Object assertThat(LocationData actual) {
        // TODO Auto-generated method stub
        return null;
    }

        protected List<LocationData> retrieveAllLocations() {
            // TODO Auto-generated method stub
            return credentialController.retrieveAllLocations();
    }

        protected LocationData buildUpdateLocation() {
        // TODO Auto-generated method stub
        return updateAddress1;
    }

        protected LocationData updateLocation(LocationData expected) {
        // TODO Auto-generated method stub
        return credentialController.updateLocation(locationData.getLocationId(),
        locationData);
    }

    

    protected void insertProvider(int which) {
        String providerSql = which == 1 ? INSERT_PROVIDER_1_SQL : INSERT_PROVIDER_2_SQL;

        jdbcTemplate.update(providerSql);
    }

    protected int rowsInProviderLocationTable() {
        String sql = "SELECT COUNT(*) FROM provider_location";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    protected void deleteLocation(Long locationId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

