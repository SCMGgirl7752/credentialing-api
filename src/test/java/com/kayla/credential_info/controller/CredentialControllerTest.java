package com.kayla.credential_info.controller;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnviroment = WebEnviroment).NONE, classes = CredentialController.class)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:schema.sql", "classpath:data.sql"})
class CredentialControllerTest extends CredentialServiceTestSupport{

    @Test
    Void testInsertLocation() {
        // Given: A new Location request
        LocationData request = buildInsertLocation(1);
        LocationData expected = buildInsertLocation(1);

        //When: The request is added to the location table
        LocationData actual = insertLocation(request);

        // Then: The location returned is what is expected
        assertThat(actual).isEqualTo(expected);

        // And: There is one row in the location table.
        assertThat(rowsInLocationTable()).isEqualTo(1);
        return null;
    }

    @Test
    Void testRetrieveAllLocations() {
        // Given: Two locations in the location table
        List<LocationData> expected = new insertTwoLocations();
        // When: all locations are retrieved
        List<LocationData> actual = retrieveAllLocations();
        // Then: the retrieved locations are the same as expected.
        assertThat(actual) .isEqualTo(expected);
        return null;
    }




}


