package com.kayla.credential_info.controller.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.kayla.credential_info.dao.LocationData;
import com.kayla.credential_info.service.CredentialService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/credential_info")
@Slf4j

public class CredentialController {

    @Autowired
    private final CredentialService credentialService;

    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @PostMapping("/location")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String postMethodName(@RequestBody String entity) {
        log.info("Received entity: {}", entity);
        credentialService.processEntity(entity);
        return entity;
    }
    
    @GetMapping("/location/{locationId}")
    public LocationData retrieveLocation(@PathVariable Long locationId){
        log.info("Retrieving location with ID={}", locationId);
        return credentialService.retrieveLocationById(locationId);
    }

    public LocationData createLocation(LocationData locationData) {
        log.info("Creating location: {}", locationData);
        // Example usage of credentialService (replace with actual logic as needed)
        return credentialService.saveLocation(locationData);
        //return locationData;
    }
}


// TODO: fix endpoints and finish with debugging