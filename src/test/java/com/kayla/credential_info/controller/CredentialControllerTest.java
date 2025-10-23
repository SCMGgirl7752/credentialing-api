package com.kayla.credential_info.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.kayla.credential_info.controller.model.CredentialController;
import com.kayla.credential_info.dao.LocationData;

@SpringBootTest(webEnvironment = WebEnvironment.NONE, classes = CredentialController.class)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:schema.sql", "classpath:data.sql"})
public class CredentialControllerTest extends CredentialServiceTestSupport{

    @Test
    void testInsertLocation() {
        // Given: A new Location request
        LocationData request = buildInsertLocation(1);
        LocationData expected = buildInsertLocation(1);

        //When: The request is added to the location table
        LocationData actual = insertLocation(request);

        // Then: The location returned is what is expected
        org.assertj.core.api.Assertions.assertThat(actual).isEqualTo(expected);

        // And: There is one row in the location table.
        org.assertj.core.api.Assertions.assertThat(rowsInLocationTable()).isEqualTo(1);

    }

    @Test
    void testRetrieveAllLocations() {
        // Given: Two locations in the location table
        List<LocationData> expected = insertTwoLocations();
        // When: all locations are retrieved
        List<LocationData> actual = retrieveAllLocations();
        // Then: the retrieved locations are the same as expected.
        org.assertj.core.api.Assertions.assertThat(actual) .isEqualTo(expected);

    }



    @Test
    void testUpdateLocation() {
        // Given: A location and an update request
        insertLocation(buildInsertLocation(1));
        LocationData expected = buildUpdateLocation();

        // When: the location is updated
        LocationData actual = updateLocation(expected);

        //Then: the location is updated as expected
        org.assertj.core.api.Assertions.assertThat(actual).isEqualTo(expected);

        //And: there is one row in the location table.
        org.assertj.core.api.Assertions.assertThat(rowsInLocationTable()).isEqualTo(1);
    }


    @Test
    void testDeleteLocation() {
        // Given: A location in the location table
        LocationData locationData = insertLocation(buildInsertLocation(1));
        Long locationId = locationData.getLocationId();

        insertProvider(1);
        insertProvider(2);

        org.assertj.core.api.Assertions.assertThat(rowsInLocationTable()) .isOne();
        org.assertj.core.api.Assertions.assertThat(rowsInProviderLocationTable()).isEqualTo(2);// made method for rows in provider table; can we do this also???
        org.assertj.core.api.Assertions.assertThat(rowsInProviderLocationTable()).isEqualTo(4);// check video part 22:00 for the testSupport part of this if we can fix/change it.
        int providerRows = rowsInProviderLocationTable(); // double check this is correct between tables.

        // When: the location is deleted
        deleteLocation(locationId);

        // Then: there are no rows in the location table.
        org.assertj.core.api.Assertions.assertThat(rowsInLocationTable()) .isZero();
        org.assertj.core.api.Assertions.assertThat(rowsInProviderLocationTable()).isZero();
        org.assertj.core.api.Assertions.assertThat(rowsInProviderLocationTable()).isZero();

        // And: the number of rows in the provider table has not changed.
        org.assertj.core.api.Assertions.assertThat(rowsInProviderLocationTable()).isEqualTo(providerRows);
    }



    
}




