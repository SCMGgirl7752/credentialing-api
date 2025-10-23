package com.kayla.credential_info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.kayla.credential_info.controller.model.CredentialController;
import com.kayla.credential_info.dao.LocationData;
import com.kayla.credential_info.entity.Location;

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
    private LocationData insertAddress1() {
        LocationData data = new LocationData();
    data.setLocationId(1L);
    data.setLocationName("123 Main St. Springfield");
    data.setLocationState("IL");
    data.setLocationZip("62701");
    data.setLocationWebsite("www.test.com");
    data.setLocationPhone("111-222-test");
    return data;
    }

    private LocationData insertAddress2() {
        LocationData data = new LocationData();
    data.setLocationId(2L);
    data.setLocationName("111 First St, Springfield");
    data.setLocationState("MO");
    data.setLocationZip("65801");
    data.setLocationWebsite("www.runtime.com");
    data.setLocationPhone("111-111-test");
    return data;
    }

    private LocationData updateAddress1() {
        LocationData data = new LocationData();
    data.setLocationId(1L);
    data.setLocationName("456 Elm St., Springfield");
    data.setLocationState("ID");
    data.setLocationZip("62702");
    data.setLocationWebsite("www.anothertest.com");
    data.setLocationPhone("222-222-test");
    return data;
    }

    //@formatter:on

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CredentialController credentialController;

    protected LocationData buildInsertLocation(int which) {
        return which == 1 ? insertAddress1() : insertAddress2();
    }
    protected int rowsInLocationTable() {
        return JdbcTestUtils.countRowsInTable(jdbcTemplate, LOCATION_TABLE);
    }

    protected LocationData insertLocation(LocationData locationData) {
        Location location = locationData.toLocation();
        LocationData clone = new LocationData(location);

        clone.setLocationId(null);
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
        return updateAddress1();
    }

    protected LocationData updateLocation(LocationData expected) {
        return credentialController.updateLocation(expected.getLocationId(), expected);
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

